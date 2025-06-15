<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Registrar.aspx.cs" Inherits="PUCP.Edu.Pe.Prog03HookeWeb.Web.Registrar" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Registro de Alumno - Academia Hooke</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body {
            margin: 0;
            font-family: 'Arial Black', sans-serif;
            background-color: #000;
            color: white;
            display: flex;
            flex-direction: column;
            align-items: center; /* Centrar contenido horizontalmente */
            justify-content: center; /* Centrar contenido verticalmente */
            min-height: 100vh;
        }
        .register-container {
            background-color: #1a1a1a;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
            width: 100%;
            max-width: 500px; /* Ancho máximo para el formulario */
            box-sizing: border-box;
            text-align: center;
        }
        .register-container h2 {
            color: white;
            margin-bottom: 30px;
            font-size: 28px;
        }
        .form-group {
            margin-bottom: 20px;
            text-align: left;
        }
        .form-group label {
            display: block;
            margin-bottom: 8px;
            font-size: 16px;
            font-weight: bold;
        }
        .form-group .form-control {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 5px;
            background-color: #333;
            color: white;
            font-size: 16px;
            box-sizing: border-box; /* Incluir padding en el ancho */
        }
        .form-group .form-control:focus {
            outline: none;
            box-shadow: 0 0 0 2px #007bff; /* Pequeño borde azul al enfocar */
        }
        .btn-register {
            background-color: #007bff; /* Color azul para el botón */
            color: white;
            padding: 12px 25px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 18px;
            font-weight: bold;
            transition: background-color 0.3s;
            width: 100%;
            margin-top: 20px;
        }
        .btn-register:hover {
            background-color: #0056b3;
        }
        .validation-message {
            color: #ff4d4d; /* Rojo para mensajes de validación */
            font-size: 14px;
            margin-top: 5px;
            display: block;
        }
        .back-to-login {
            margin-top: 25px;
            font-size: 16px;
        }
        .back-to-login a {
            color: #007bff;
            text-decoration: none;
            transition: color 0.3s;
        }
        .back-to-login a:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
    <form id="formRegistro" runat="server">
        <div class="register-container">
            <h2>Registro de Alumno</h2>

            <div class="form-group">
                <label for="txtNombre">Nombre:</label>
                <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control" Placeholder="Ingresa tu nombre"></asp:TextBox>
                <asp:RequiredFieldValidator ID="rfvNombre" runat="server" ControlToValidate="txtNombre"
                    ErrorMessage="El nombre es obligatorio." CssClass="validation-message"></asp:RequiredFieldValidator>
            </div>

           <div class="form-group">
                <label for="txtApellido">Apellido:</label>
                <asp:TextBox ID="txtApellido" runat="server" CssClass="form-control" Placeholder="Ingresa tu apellido"></asp:TextBox>
                <asp:RequiredFieldValidator ID="rfvApellido" runat="server" ControlToValidate="txtApellido"
                    ErrorMessage="El apellido es obligatorio." CssClass="validation-message"></asp:RequiredFieldValidator>
            </div>

            <div class="form-group">
                <label for="txtDNI">DNI:</label>
                <asp:TextBox ID="txtDNI" runat="server" CssClass="form-control" Placeholder="Ingresa tu DNI"></asp:TextBox>
                <asp:RequiredFieldValidator ID="rfvDNI" runat="server" ControlToValidate="txtDNI"
                    ErrorMessage="El DNI es obligatorio." CssClass="validation-message"></asp:RequiredFieldValidator>
            </div>

            <div class="form-group">
                <label for="txtEmail">Email:</label>
                <asp:TextBox ID="txtEmail" runat="server" CssClass="form-control" TextMode="Email" Placeholder="ejemplo@dominio.com"></asp:TextBox>
                <asp:RequiredFieldValidator ID="rfvEmail" runat="server" ControlToValidate="txtEmail"
                    ErrorMessage="El email es obligatorio." CssClass="validation-message"></asp:RequiredFieldValidator>
                <asp:RegularExpressionValidator ID="revEmail" runat="server" ControlToValidate="txtEmail"
                    ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"
                    ErrorMessage="Formato de email inválido." CssClass="validation-message"></asp:RegularExpressionValidator>
            </div>

            <div class="form-group">
                <label for="txtFechaNacimiento">Fecha de Nacimiento (Opcional):</label>
                <asp:TextBox ID="txtFechaNacimiento" runat="server" CssClass="form-control" TextMode="Date"></asp:TextBox>
            </div>

            <div class="form-group">
                <label for="txtCarrera">Carrera:</label>
                <asp:TextBox ID="txtCarrera" runat="server" CssClass="form-control" Placeholder="Ingresa tu carrera (Opcional):"></asp:TextBox>
                </div>

            <div class="form-group">
                <label for="txtPassword">Contraseña:</label>
                <asp:TextBox ID="txtPassword" runat="server" CssClass="form-control" TextMode="Password" Placeholder="Crea tu contraseña"></asp:TextBox>
                <asp:RequiredFieldValidator ID="rfvPassword" runat="server" ControlToValidate="txtPassword"
                    ErrorMessage="La contraseña es obligatoria." CssClass="validation-message"></asp:RequiredFieldValidator>
            </div>

            <div class="form-group">
                <label for="txtConfirmPassword">Confirmar Contraseña:</label>
                <asp:TextBox ID="txtConfirmPassword" runat="server" CssClass="form-control" TextMode="Password" Placeholder="Confirma tu contraseña"></asp:TextBox>
                <asp:RequiredFieldValidator ID="rfvConfirmPassword" runat="server" ControlToValidate="txtConfirmPassword"
                    ErrorMessage="Confirmar contraseña es obligatorio." CssClass="validation-message"></asp:RequiredFieldValidator>
                <asp:CompareValidator ID="cmpPassword" runat="server" ControlToValidate="txtConfirmPassword"
                    ControlToCompare="txtPassword" ErrorMessage="Las contraseñas no coinciden." CssClass="validation-message"></asp:CompareValidator>
            </div>

            <asp:Button ID="btnRegistrar" runat="server" Text="Registrarse" CssClass="btn-register" OnClick="btnRegistrar_Click" />

            <div class="back-to-login">
                ¿Ya tienes una cuenta? <a href="Login.aspx">Iniciar Sesión</a>
            </div>
            

        </div>
    </form>
</body>
</html>
