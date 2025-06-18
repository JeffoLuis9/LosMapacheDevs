<%@ Page Title="" Language="C#" MasterPageFile="~/SiteAlumno.Master" AutoEventWireup="true" CodeBehind="RegistrarMatricula.aspx.cs" Inherits="PUCP.Edu.Pe.Prog03HookeWeb.Web.RegistrarMatricula" %>
<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
    Matricula
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
     <style>
        /* Estilos generales del contenedor del formulario */
        .form-container {
            background-color: #1a1a1a;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
            width: 100%;
            max-width: 700px; /* Ancho un poco mayor para más campos */
            margin: 50px auto;
            box-sizing: border-box;
            color: white;
        }

        h2 {
            color: white;
            text-align: center;
            margin-bottom: 30px;
            font-size: 28px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            font-size: 18px;
        }

        .form-control{
            width: calc(70% - 20px);
            padding: 10px;
            border: 1px solid #444;
            border-radius: 5px;
            background-color: #333;
            color: white;
            font-size: 16px;
            box-sizing: border-box;
            -webkit-appearance: none; /* Remover estilo por defecto de select en algunos navegadores */
            -moz-appearance: none;
            appearance: none;
            background-image: none;
            background-repeat: no-repeat;
            background-position: right 10px top 50%;
            background-size: 12px auto;
        } 
        
        .form-select {
            width: calc(100% - 20px);
            padding: 10px;
            border: 1px solid #444;
            border-radius: 5px;
            background-color: #333;
            color: white;
            font-size: 16px;
            box-sizing: border-box;
            -webkit-appearance: none; /* Remover estilo por defecto de select en algunos navegadores */
            -moz-appearance: none;
            appearance: none;
            background-image: url('data:image/svg+xml;charset=US-ASCII,%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20width%3D%22292.4%22%20height%3D%22292.4%22%3E%3Cpath%20fill%3D%22%23ffffff%22%20d%3D%22M287%2C197.973L146.2%2C67.616L5.4%2C197.973H287z%22%2F%3E%3C%2Fsvg%3E'); /* Flecha personalizada para select */
            background-repeat: no-repeat;
            background-position: right 10px top 50%;
            background-size: 12px auto;
        }
        .form-control:focus, .form-select:focus {
            outline: none;
            border-color: #66afe9;
            box-shadow: 0 0 8px rgba(102, 175, 233, 0.6);
        }
        
        /* Estilos para campos deshabilitados (solo lectura) */
        .form-control[disabled], .form-select[disabled] {
            background-color: #2a2a2a;
            color: #ccc;
            cursor: not-allowed;
            opacity: 0.8;
        }

        .button-group {
            text-align: center;
            margin-top: 30px;
        }

        .btn {
            padding: 12px 25px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 18px;
            font-weight: bold;
            transition: background-color 0.3s ease;
            margin: 0 10px;
            text-decoration: none;
            display: inline-block;
        }

        .btn-primary {
            background-color: #28a745; /* Verde para Registrar */
            color: white;
        }
        .btn-primary:hover {
            background-color: #218838;
        }

        .btn-secondary {
            background-color: #6c757d; /* Gris para Cancelar */
            color: white;
        }
        .btn-secondary:hover {
            background-color: #5a6268;
        }

        /* Mensaje de estado */
        .message-success {
            color: green;
            text-align: center;
            display: block;
            margin-top: 20px;
            font-weight: bold;
        }
        .message-error {
            color: red;
            text-align: center;
            display: block;
            margin-top: 20px;
            font-weight: bold;
        }
    </style>

    <div class="form-container" runat="server">
        <h2>Registro de Matrícula</h2>

        

            
        <div class="form-group">
            <label for="ddlNivel">Nivel:</label>
           <asp:DropDownList ID="ddlNivel" runat="server" CssClass="form-control">
                    <asp:ListItem Text="-- Seleccione un nivel --" Value="" />
                    <asp:ListItem Text="1" Value="1" />
                    <asp:ListItem Text="2" Value="2" />
                    <asp:ListItem Text="3" Value="3" />
                    <asp:ListItem Text="4" Value="4" />
                    <asp:ListItem Text="5" Value="5" />
                    <asp:ListItem Text="6" Value="6" />
                    <asp:ListItem Text="7" Value="7" />
                    <asp:ListItem Text="8" Value="8" />
                    <asp:ListItem Text="9" Value="9" />
                    <asp:ListItem Text="10" Value="10" />
            </asp:DropDownList>
            <asp:Button class="button-group" ID="btnBuscarCursos" runat="server" Text="Buscar Cursos" CssClass="btn btn-info mt-2" OnClick="btnBuscarCursos_Click" />
        </div>

        <div class="form-group">
            <label for="<%= ddlModalidad.ClientID %>">Modalidad:</label>
            <asp:DropDownList ID="ddlModalidad" runat="server" CssClass="form-select">
                <asp:ListItem Text="-- Seleccione una modalidad --" Value="" />
                <asp:ListItem Text="Presencial" Value="Presencial" />
                <asp:ListItem Text="Virtual" Value="Virtual" />
                <asp:ListItem Text="Semipresencial" Value="Semipresencial" />
            </asp:DropDownList>
            <asp:RequiredFieldValidator ID="rfvModalidad" runat="server" ControlToValidate="ddlModalidad"
                InitialValue="0" ErrorMessage="Debe seleccionar una modalidad." ForeColor="Red" Display="Dynamic"></asp:RequiredFieldValidator>
        </div>
        
        <div class="form-group">
            <label for="<%= ddlCurso.ClientID %>">Curso:</label>
            <asp:DropDownList ID="ddlCurso" runat="server" AutoPostBack="true" CssClass="form-select" OnSelectedIndexChanged="ddlCurso_SelectedIndexChanged"></asp:DropDownList>
            <asp:RequiredFieldValidator ID="rfvCurso" runat="server" ControlToValidate="ddlCurso"
                InitialValue="0" ErrorMessage="Debe seleccionar un curso." ForeColor="Red" Display="Dynamic"></asp:RequiredFieldValidator>
        </div>

        <div class="form-group">
            <label for="<%= ddlTipoSesion.ClientID %>">Tipo de Sesión:</label>
            <asp:DropDownList ID="ddlTipoSesion" runat="server" CssClass="form-select"></asp:DropDownList>
            <asp:RequiredFieldValidator ID="rfvTipoSesion" runat="server" ControlToValidate="ddlTipoSesion"
                InitialValue="0" ErrorMessage="Debe seleccionar un tipo de sesión." ForeColor="Red" Display="Dynamic"></asp:RequiredFieldValidator>
        </div>

        <div class="form-group">
            <label for="<%= ddlProfesor.ClientID %>">Profesor:</label>
            <asp:DropDownList ID="ddlProfesor" runat="server" CssClass="form-select"></asp:DropDownList>
            <asp:RequiredFieldValidator ID="rfvProfesor" runat="server" ControlToValidate="ddlProfesor"
                InitialValue="0" ErrorMessage="Debe seleccionar un profesor." ForeColor="Red" Display="Dynamic"></asp:RequiredFieldValidator>
        </div>

        <div class="form-group">
            <label for="<%= ddlSede.ClientID %>">Sede:</label>
            <asp:DropDownList ID="ddlSede" runat="server" CssClass="form-select"></asp:DropDownList>
            <asp:RequiredFieldValidator ID="rfvSede" runat="server" ControlToValidate="ddlSede"
                InitialValue="0" ErrorMessage="Debe seleccionar una sede." ForeColor="Red" Display="Dynamic"></asp:RequiredFieldValidator>
        </div>
        <div class="button-group">
            <asp:Button ID="btnAccion" runat="server" Text="Registrar" OnClick="btnAccion_Click" CssClass="btn btn-primary" />
            <asp:Button ID="btnCancelar" runat="server" Text="Cancelar" OnClick="btnCancelar_Click" CssClass="btn btn-secondary" CausesValidation="False" />
        </div>

    </div>
</asp:Content>
