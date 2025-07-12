<!DOCTYPE html>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Login Superfresh</title>
    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Orbitron:wght@700&display=swap');

        /* Fondo oscuro y degradado */
        body {
            background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);
            min-height: 100vh;
            margin: 0;
            padding: 0;
            overflow: hidden;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            color: #e0f7fa;
            display: flex;
            justify-content: center;
            align-items: center;
            position: relative;
        }

        /* Efecto nieve */
        .snowflake {
            position: fixed;
            top: -10px;
            background: white;
            border-radius: 50%;
            opacity: 0.8;
            pointer-events: none;
            animation-name: fall, sway;
            animation-timing-function: linear, ease-in-out;
            animation-iteration-count: infinite;
            animation-direction: normal, alternate;
        }

        @keyframes fall {
            0% {
                transform: translateY(-10px);
                opacity: 0.8;
            }
            100% {
                transform: translateY(110vh);
                opacity: 0;
            }
        }

        @keyframes sway {
            0% {
                transform: translateX(0);
            }
            100% {
                transform: translateX(20px);
            }
        }

        /* Crear muchas partículas de nieve */
        /* Usaremos JS para generar */

        /* Caja del login */
        .login-card {
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(10px);
            border-radius: 1rem;
            padding: 2.5rem 2rem;
            width: 100%;
            max-width: 380px;
            border: 3px solid;
            /* animación de brillo azul suave */
            animation: borderGlow 4s ease-in-out infinite;
            box-shadow: 0 0 15px rgba(0, 198, 255, 0.5);
            position: relative;
            z-index: 1;
        }

        @keyframes borderGlow {
            0% {
                border-color: #00bfff;
                box-shadow: 0 0 15px #00bfff;
            }
            50% {
                border-color: #1e90ff;
                box-shadow: 0 0 25px #1e90ff;
            }
            100% {
                border-color: #00bfff;
                box-shadow: 0 0 15px #00bfff;
            }
        }

        h2 {
            color: #a6e3f2;
            text-align: center;
            margin-bottom: 2rem;
            font-weight: 700;
            text-shadow: 0 0 10px rgba(255, 255, 255, 0.25);
            font-family: 'Orbitron', sans-serif;
            user-select: none;
            transition: color 2s ease;
        }
        .login-card:hover h2 {
            color: #00c6ff;
            text-shadow: 0 0 15px #00c6ff;
        }

        .form-control {
            background-color: transparent;
            border: 2px solid #b2ebf2;
            color: #e0f7fa;
            transition: border-color 0.5s ease, box-shadow 0.5s ease;
            border-radius: 6px;
            padding: 10px;
        }
        .form-control:focus {
            border-color: #00c6ff;
            box-shadow: 0 0 12px #00c6ff;
            background-color: rgba(255, 255, 255, 0.1);
            color: #fff;
            outline: none;
        }
        .form-control.is-invalid {
            border-color: #ff4d4d;
            box-shadow: 0 0 8px #ff4d4d;
            background-color: rgba(255, 77, 77, 0.1);
            color: #ffdddd;
        }

        label {
            color: #b3e5fc;
            transition: color 1.5s ease;
        }
        .login-card:hover label {
            color: #00c6ff;
        }

        .btn-ice {
            background: linear-gradient(90deg, #00c6ff, #0072ff);
            border: none;
            color: white;
            font-weight: 600;
            transition: background 0.4s ease, box-shadow 0.4s ease;
            box-shadow: 0 0 15px rgba(0, 198, 255, 0.7);
            border-radius: 6px;
            padding: 10px 0;
        }
        .btn-ice:hover {
            background: linear-gradient(90deg, #0099cc, #004c99);
            box-shadow: 0 0 25px rgba(0, 198, 255, 1);
        }

        .invalid-feedback {
            color: #ff4d4d;
            font-weight: 500;
            display: none;
            margin-top: 0.25rem;
            font-size: 0.9rem;
        }
        .invalid-feedback.active {
            display: block;
        }

    </style>
</head>
<body>

    <div class="login-card shadow">
        <h2>Inicio de sesión</h2>
        <form id="loginForm" action="AutenticacionServlet" method="post" autocomplete="off" novalidate>
            <div class="mb-4">
                <label for="username" class="form-label">Usuario:</label>
                <input
                    type="text"
                    id="username"
                    name="username"
                    class="form-control"
                    required
                    autocomplete="off"
                    pattern=".{3,}"
                    title="Ingrese al menos 3 caracteres"
                />
                <div class="invalid-feedback">Por favor ingrese un usuario válido (mínimo 3 caracteres).</div>
            </div>
            <div class="mb-5">
                <label for="password" class="form-label">Contraseña:</label>
                <input
                    type="password"
                    id="password"
                    name="password"
                    class="form-control"
                    required
                    autocomplete="off"
                    pattern=".{6,}"
                    title="Ingrese al menos 6 caracteres"
                />
                <div class="invalid-feedback">Por favor ingrese una contraseña válida (mínimo 6 caracteres).</div>
            </div>
            <button type="submit" class="btn btn-ice w-100">Entrar</button>
        </form>
    </div>

    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Script para generar nieve -->
    <script>
        const snowCount = 40;
        for(let i = 0; i < snowCount; i++) {
            const snowflake = document.createElement('div');
            snowflake.classList.add('snowflake');
            snowflake.style.width = `${Math.random() * 4 + 2}px`;
            snowflake.style.height = snowflake.style.width;
            snowflake.style.left = `${Math.random() * 100}vw`;
            snowflake.style.animationDuration = `${Math.random() * 10 + 5}s`;
            snowflake.style.animationDelay = `${Math.random() * 10}s`;
            snowflake.style.opacity = Math.random();
            document.body.appendChild(snowflake);
        }
    </script>

    <script>
        (function () {
            'use strict';

            const form = document.getElementById('loginForm');
            const username = document.getElementById('username');
            const password = document.getElementById('password');

            form.addEventListener('submit', function (event) {
                let isValid = true;

                if (!username.checkValidity()) {
                    username.classList.add('is-invalid');
                    isValid = false;
                } else {
                    username.classList.remove('is-invalid');
                }

                if (!password.checkValidity()) {
                    password.classList.add('is-invalid');
                    isValid = false;
                } else {
                    password.classList.remove('is-invalid');
                }

                if (!isValid) {
                    event.preventDefault();
                    event.stopPropagation();
                }
            });

            // Opcional: eliminar el borde rojo cuando el usuario corrige el campo
            username.addEventListener('input', () => {
                if (username.checkValidity()) {
                    username.classList.remove('is-invalid');
                }
            });

            password.addEventListener('input', () => {
                if (password.checkValidity()) {
                    password.classList.remove('is-invalid');
                }
            });
        })();
    </script>

</body>
</html>
