<%@ Page Title="" Language="C#" MasterPageFile="~/SiteAdministrador.Master" AutoEventWireup="true" CodeBehind="RegistrarCurso.aspx.cs" Inherits="PUCP.Edu.Pe.Prog03HookeWeb.Web.RegistrarCurso" %>
<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
    <asp:Literal ID="litPageTitle" runat="server">Registrar Curso</asp:Literal>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <style>
        /* Reutiliza los estilos de formulario de RegistrarProfesor, ajustando nombres si es necesario */
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
        <h2 id="formTitle" runat="server">Registrar Nuevo Curso</h2> 

        <div class="form-group">
            <label for="txtCodigo">Código:</label>
            <asp:TextBox ID="txtCodigo" runat="server" CssClass="form-control" Placeholder="Ingresa el código del curso"></asp:TextBox>
            <asp:RequiredFieldValidator ID="rfvCodigo" runat="server" ControlToValidate="txtCodigo"
                ErrorMessage="El código es obligatorio." CssClass="validation-message"></asp:RequiredFieldValidator>
        </div>

        <div class="form-group">
            <label for="txtNombre">Nombre del Curso:</label>
            <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control" Placeholder="Ingresa el nombre del curso"></asp:TextBox>
            <asp:RequiredFieldValidator ID="rfvNombre" runat="server" ControlToValidate="txtNombre"
                ErrorMessage="El nombre es obligatorio." CssClass="validation-message"></asp:RequiredFieldValidator>
        </div>

        <div class="form-group">
            <label for="txtNivel">Nivel:</label>
            <asp:TextBox ID="txtNivel" runat="server" CssClass="form-control" TextMode="Number" Placeholder="Ingresa el nivel del curso"></asp:TextBox>
            <asp:RequiredFieldValidator ID="rfvNivel" runat="server" ControlToValidate="txtNivel"
                ErrorMessage="El nivel es obligatorio." CssClass="validation-message"></asp:RequiredFieldValidator>
            <asp:RangeValidator ID="rvNivel" runat="server" ControlToValidate="txtNivel" Type="Integer"
                MinimumValue="1" MaximumValue="10" ErrorMessage="El nivel debe ser un número entre 1 y 10." CssClass="validation-message"></asp:RangeValidator>
        </div>

        <div class="form-group">
            <label for="txtHoraInicio">Hora de Inicio (0-23):</label>
            <asp:TextBox ID="txtHoraInicio" runat="server" CssClass="form-control" TextMode="Number" Placeholder="Ej: 9"></asp:TextBox>
            <asp:RequiredFieldValidator ID="rfvHoraInicio" runat="server" ControlToValidate="txtHoraInicio"
                ErrorMessage="La hora de inicio es obligatoria." CssClass="validation-message"></asp:RequiredFieldValidator>
            <asp:RangeValidator ID="rvHoraInicio" runat="server" ControlToValidate="txtHoraInicio" Type="Integer"
                MinimumValue="0" MaximumValue="23" ErrorMessage="La hora de inicio debe ser entre 0 y 23." CssClass="validation-message"></asp:RangeValidator>
        </div>

        <div class="form-group">
            <label for="txtHoraFin">Hora de Fin (0-23):</label>
            <asp:TextBox ID="txtHoraFin" runat="server" CssClass="form-control" TextMode="Number" Placeholder="Ej: 11"></asp:TextBox>
            <asp:RequiredFieldValidator ID="rfvHoraFin" runat="server" ControlToValidate="txtHoraFin"
                ErrorMessage="La hora de fin es obligatoria." CssClass="validation-message"></asp:RequiredFieldValidator>
            <asp:RangeValidator ID="rvHoraFin" runat="server" ControlToValidate="txtHoraFin" Type="Integer"
                MinimumValue="0" MaximumValue="23" ErrorMessage="La hora de fin debe ser entre 0 y 23." CssClass="validation-message"></asp:RangeValidator>
            <asp:CompareValidator ID="cmpHoras" runat="server" ControlToValidate="txtHoraFin" ControlToCompare="txtHoraInicio"
                Operator="GreaterThan" Type="Integer" ErrorMessage="La hora de fin debe ser posterior a la hora de inicio." CssClass="validation-message"></asp:CompareValidator>
        </div>

        <asp:Button ID="btnRegistrar" runat="server" Text="Registrar" CssClass="btn-register" OnClick="btnRegistrar_Click" />

        <asp:HiddenField ID="hdnCursoId" runat="server" Value="0" /> 
        
    </div>
</asp:Content>
