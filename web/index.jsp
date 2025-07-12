<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="Control.Conexion"%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

    if (session == null || session.getAttribute("userId") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    int userId = (Integer) session.getAttribute("userId");
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    String nombreUsuario = "Usuario";
    Map<String, List<String[]>> menuMap = new TreeMap<>(); // Ordena alfabéticamente por clave

    try {
        Conexion cx = new Conexion();
        con = cx.conectar();

        ps = con.prepareStatement(
            "SELECT p.NOMBRE, p.APELLIDO_PATERNO FROM persona p JOIN usuario u ON p.ID_PERSONA=u.ID_PERSONA WHERE u.ID_USUARIO=?");
        ps.setInt(1, userId);
        rs = ps.executeQuery();
        if (rs.next()) {
            nombreUsuario = rs.getString("NOMBRE") + " " + rs.getString("APELLIDO_PATERNO");
        }
        rs.close(); ps.close();

        ps = con.prepareStatement(
            "SELECT NOMBRE_MENU, NOMBRE_FORMULARIO, NOMBRE_SUBMENU FROM vista_permisos WHERE ID_USUARIO=? ORDER BY NOMBRE_MENU, NOMBRE_SUBMENU");
        ps.setInt(1, userId);
        rs = ps.executeQuery();
        while (rs.next()) {
            String menu = rs.getString("NOMBRE_MENU");
            menuMap.computeIfAbsent(menu, k -> new ArrayList<>())
                   .add(new String[]{rs.getString("NOMBRE_FORMULARIO"), rs.getString("NOMBRE_SUBMENU")});
        }
        rs.close(); ps.close();

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>SUPERFRESH - Panel</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    <style>
        :root {
            --azul-oscuro: #0e477a;
            --azul-claro: #4dc0f7;
            --fondo: #eff8ff;
            --texto: #ffffff;
            --hover: #9ed4ff;
        }
        * { margin:0; padding:0; box-sizing:border-box; }
        body {
            height: 100vh; display: flex; flex-direction: column;
            font-family: 'Segoe UI', sans-serif;
            background: var(--fondo);
        }

        .top-bar {
            height: 70px;
            background: var(--azul-oscuro);
            color: var(--texto);
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 0 32px;
            font-size: 20px;
            font-weight: bold;
            position: relative;
        }

        .main {
            flex: 1;
            display: flex;
            overflow: hidden;
        }

        .sidebar {
            width: 260px;
            background: var(--azul-oscuro);
            color: var(--texto);
            overflow-y: auto;
            padding-top: 20px;
        }

        .menu-btn {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 14px 24px;
            font-weight: bold;
            font-size: 15px;
            background: none;
            border: none;
            color: var(--texto);
            width: 100%;
            cursor: pointer;
            transition: background 0.2s ease;
        }

        .menu-btn:hover {
            background: var(--azul-claro);
            color: #002b4d;
        }

        .menu-btn i.rotate {
            transform: rotate(90deg);
            transition: transform 0.3s ease;
        }

        .submenu {
            max-height: 0;
            overflow: hidden;
            transition: max-height 0.3s ease;
            background: #14578f;
        }

        .submenu.show {
            max-height: 500px;
        }

        .submenu a {
            display: block;
            padding: 12px 32px;
            color: var(--texto);
            text-decoration: none;
            font-size: 14px;
        }

        .submenu a:hover {
            background: var(--hover);
            color: #002b4d;
        }

        .content {
            flex: 1;
            padding: 20px;
            background: var(--fondo);
            overflow: auto;
        }

        iframe {
            width: 100%;
            height: 100%;
            border: 2px solid var(--azul-claro);
            border-radius: 8px;
        }

        .user-dropdown {
            position: relative;
            display: inline-block;
        }

        .user-btn {
            background: none;
            border: none;
            color: var(--texto);
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            display: flex;
            align-items: center;
        }

        .user-btn i {
            margin-left: 8px;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            top: 100%;
            right: 0;
            background-color: white;
            min-width: 180px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.2);
            border-radius: 6px;
            z-index: 10;
        }

        .dropdown-content form {
            margin: 0;
        }

        .logout-btn {
            width: 100%;
            padding: 12px;
            border: none;
            background: none;
            text-align: left;
            font-weight: bold;
            color: #333;
            cursor: pointer;
        }

        .logout-btn:hover {
            background-color: #f0f0f0;
            color: #000;
        }

        @media (max-width: 768px) {
            .sidebar { width: 200px; }
            .top-bar { font-size: 18px; padding: 0 16px; }
        }
    </style>
</head>
<body>
    <div class="top-bar">
        <div>SUPERFRESH</div>
        <div class="user-dropdown">
            <button onclick="toggleDropdown()" class="user-btn">
                Bienvenido, <%= nombreUsuario %> <i class="fas fa-user-circle"></i>
            </button>
            <div id="userMenu" class="dropdown-content">
                <form action="logout" method="post">
                    <button type="submit" class="logout-btn"><i class="fas fa-sign-out-alt"></i> Cerrar Sesión</button>
                </form>
            </div>
        </div>
    </div>

    <div class="main">
        <div class="sidebar">
            <% for (Map.Entry<String, List<String[]>> e : menuMap.entrySet()) {
                String menu = e.getKey();
                String id = "menu_" + menu.replaceAll("\\W+", "_");
            %>
                <button class="menu-btn" onclick="toggleMenu('<%=id%>', this)">
                    <span><i class="fas fa-folder"></i> <%=menu%></span>
                    <i class="fas fa-chevron-right"></i>
                </button>
                <div id="<%=id%>" class="submenu">
                    <% for (String[] sub : e.getValue()) { %>
                        <a href="<%=sub[0]%>" target="contentFrame"><i class="fas fa-angle-right"></i> <%=sub[1]%></a>
                    <% } %>
                </div>
            <% } %>
        </div>

        <div class="content">
            <iframe name="contentFrame">
                
            </iframe>
        </div>
    </div>

    <script>
        function toggleMenu(id, btn) {
            const submenu = document.getElementById(id);
            submenu.classList.toggle('show');
            const icon = btn.querySelector('i.fas.fa-chevron-right');
            icon.classList.toggle('rotate');
        }

        function toggleDropdown() {
            const menu = document.getElementById("userMenu");
            menu.style.display = (menu.style.display === "block") ? "none" : "block";
        }

        window.onclick = function(event) {
            if (!event.target.closest('.user-dropdown')) {
                const menu = document.getElementById("userMenu");
                if (menu) menu.style.display = "none";
            }
        }
    </script>
</body>
</html>
