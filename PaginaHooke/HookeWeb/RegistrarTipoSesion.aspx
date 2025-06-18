<%@ Page Title="" Language="C#" MasterPageFile="~/SiteAdministrador.Master" AutoEventWireup="true" CodeBehind="RegistrarTipoSesion.aspx.cs" Inherits="PUCP.Edu.Pe.Prog03HookeWeb.Web.RegistrarTipoSesion" %>
<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
    <asp:Literal ID="litPageTitle" runat="server">Registrar Tipo de Sesión</asp:Literal>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <style>
        /* Reutiliza los mismos estilos de formulario que en RegistrarCurso.aspx */
        .register-container { 
            background-color: #1a1a1a;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
            width: 100%;
            max-width: 500px;
            box-sizing: border-box;
            margin: 20px auto;
            text-align: center;
        }
        .register-container h2 {
            color: white;
            margin-bottom: 30px;
            font-size: 28px;
        }
        .form-group { margin-bottom: 20px; text-align: left; }
        .form-group label { display: block; margin-bottom: 8px; font-size: 16px; font-weight: bold; }
        .form-group .form-control { width: 100%; padding: 12px; border: none; border-radius: 5px; background-color: #333; color: white; font-size: 16px; box-sizing: border-box; }
        .form-group .form-control:focus { outline: none; box-shadow: 0 0 0 2px #007bff; }
        .btn-register { background-color: #007bff; color: white; padding: 12px 25px; border: none; border-radius: 5px; cursor: pointer; font-size: 18px; font-weight: bold; transition: background-color 0.3s; width: 100%; margin-top: 20px; }
        .btn-register:hover { background-color: #0056b3; }
        .validation-message { color: #ff4d4d; font-size: 14px; margin-top: 5px; display: block; }
    </style>

    <div class="register-container">
        <h2 id="formTitle" runat="server">Registrar Nuevo Tipo de Sesión</h2> 

        <div class="form-group">
            <label for="txtTipo">Tipo de Sesión:</label>

            <asp:TextBox ID="txtTipo" runat="server" CssClass="form-control" Placeholder="Ej: Individual, Grupal"></asp:TextBox>

            <asp:RequiredFieldValidator ID="rfvTipo" runat="server" ControlToValidate="txtTipo"
                ErrorMessage="El tipo de sesión es obligatorio." CssClass="validation-message"></asp:RequiredFieldValidator>
        </div>

        <div class="form-group">
            <label for="txtPrecio">Precio:</label>
            <asp:TextBox ID="txtPrecio" runat="server" CssClass="form-control" TextMode="Number" Placeholder="Ej: 50.00"></asp:TextBox>
            <asp:RequiredFieldValidator ID="rfvPrecio" runat="server" ControlToValidate="txtPrecio"
                ErrorMessage="El precio es obligatorio." CssClass="validation-message"></asp:RequiredFieldValidator>
            <asp:CompareValidator ID="cmpPrecio" runat="server" ControlToValidate="txtPrecio" Type="Double"
                Operator="GreaterThanEqual" ValueToCompare="0" ErrorMessage="El precio debe ser un número válido mayor o igual a 0." CssClass="validation-message"></asp:CompareValidator>
        </div>

        <asp:Button ID="btnRegistrar" runat="server" Text="Registrar" CssClass="btn-register" OnClick="btnRegistrar_Click" />

        <asp:HiddenField ID="hdnTipoSesionId" runat="server" Value="0" /> 
 
    </div>
</asp:Content>
