<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="PUCP.Edu.Pe.Prog03HookeWeb.Web.Login" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Login - Academia Hooke</title>
    <style>
        body {
            background-color: #000;
            font-family: 'Arial Black', sans-serif;
            color: white;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center; /* Center horizontally */
            align-items: flex-start; /* Align to the top vertically */
            min-height: 100vh;
        }

        .container {
            display: flex;
            flex-direction: row; /* Keep elements side by side */
            justify-content: center; /* Center content within container */
            align-items: center; /* Align items vertically in the middle of container */
            width: 90%; /* Increase overall width to fill more space */
            max-width: 1400px; /* Allow more space */
            padding: 20px 20px; /* Reduce top padding to move content higher */
            box-sizing: border-box;
            margin-top: 20px; /* Small margin from the very top */
        }

        .left-side {
            display: flex;
            flex-direction: column;
            justify-content: flex-start;
            align-items: flex-start; /* Align items to the left within left-side for better text alignment */
            gap: 20px;
            /* Removed text-align: center; to allow text to align left */
        }

        .logo {
            font-size: 32px; /* Adjusted font size to fit on one line */
            font-weight: bold;
            margin-bottom: 0;
            display: flex;
            align-items: center;
            justify-content: flex-start; /* Align logo elements to the left */
            gap: 20px; /* Increased gap for better spacing */
            width: 100%; /* Ensure it takes full width for alignment */
            white-space: nowrap; /* Prevents text from wrapping to the next line */
        }

        h2 {
            margin: 20px 0; /* Add margin for spacing */
            font-size: 28px; /* Reduced heading size */
            align-self: flex-start; /* Align to the left within left-side */
        }

        .login-box {
            background-color: #1a1a1a;
            padding: 40px; /* Increased padding */
            border-radius: 10px;
            width: 400px; /* Increased width */
            box-sizing: border-box; /* Include padding in width */
            display: flex;
            flex-direction: column;
            align-items: center; /* Center inputs and buttons */
            align-self: flex-start; /* Align to the left within left-side */
        }

        .input-style {
            width: 100%; /* Make input fill login-box width */
            padding: 15px; /* Increased padding */
            margin: 10px 0; /* Increased margin */
            border: 2px solid #ccc;
            border-radius: 5px;
            font-family: Arial, sans-serif;
            background-color: white;
            color: black;
            box-sizing: border-box;
            font-size: 16px; /* Increased font size for inputs */
        }

        .login-box a {
            color: #ccc;
            font-size: 14px; /* Increased font size */
            display: block;
            margin-top: 15px; /* Increased margin */
            text-align: center;
            text-decoration: none;
        }

        /* Estilo para los botones */
        .login-box input[type=submit],
        .login-box input[type=button] {
            background-color: #333;
            color: white;
            border: none;
            padding: 15px; /* Increased padding */
            width: 100%; /* Make buttons fill login-box width */
            margin-top: 15px; /* Increased margin */
            cursor: pointer;
            font-family: Arial, sans-serif;
            border-radius: 5px;
            font-size: 18px; /* Increased font size for buttons */
        }

        /* Estilo específico para el botón Registrarse, si quieres que se vea diferente */
        #btnRegister {
            background-color: #555;
        }

        .owl-img {
            max-width: 600px; /* Increased max-width for larger owl */
            height: auto;
            margin-left: 100px; /* Increased margin to push it further right */
            margin-top: 100px; /* Added margin-top to move the image down */
            padding-top: 0;
            align-self: flex-start; /* Still align to the top, but margin pushes it down */
        }

        .header-owl-logo {
            width: 80px; /* Increased logo size */
            height: auto;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div class="container">
            <div class="left-side">
                <div class="logo">
                    <img src="Images/LogoFinal_edited.png" alt="Academia Hooke Logo" class="header-owl-logo" />
                    ACADEMIA HOOKE
                </div>
                <h2>INICIAR SESIÓN</h2>
                <div class="login-box">
                    <asp:TextBox ID="txtEmail" runat="server" Placeholder="Correo electrónico" TextMode="Email" CssClass="input-style"></asp:TextBox>
                    <asp:TextBox ID="txtPassword" runat="server" Placeholder="Contraseña" TextMode="Password" CssClass="input-style"></asp:TextBox>
                    <asp:Label ID="lblErrorMessage" runat="server" CssClass="error-message" EnableViewState="false"></asp:Label>
                    <asp:Button ID="btnLogin" runat="server" Text="Iniciar sesión" OnClick="btnLogin_Click" />
                    <asp:Button ID="btnRegister" runat="server" Text="Registrarse" OnClick="btnRegister_Click" />
                </div>
            </div>
            <img src="Images/HOOKIE_INGE.png" alt="Owl Illustration" class="owl-img" />
        </div>
    </form>
</body>
</html>
