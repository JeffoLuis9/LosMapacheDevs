<%@ Page Title="" Language="C#" MasterPageFile="~/SiteAdministrador.Master" AutoEventWireup="true" CodeBehind="GestionarSede.aspx.cs" Inherits="PUCP.Edu.Pe.Prog03HookeWeb.Web.GestionarSede" %>
<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
    <asp:Literal ID="litPageTitle" runat="server">Registrar Sede</asp:Literal>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <style>
        /* Estilos específicos para esta página */
        .register-sede-container {
            background-color: #1a1a1a;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
            width: 100%;
            max-width: 600px; /* Ancho máximo para el formulario */
            margin: 20px auto; /* Centrar y dar un poco de margen */
            box-sizing: border-box;
            text-align: center;
        }
        .register-sede-container h2 {
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

        /* Estilos base para todos los controles de formulario (TextBox y DropDownList) */
        .form-group .form-control {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 5px;
            background-color: #333;
            color: white;
            font-size: 16px;
            box-sizing: border-box;
        }

        /* ESTILOS ESPECÍFICOS PARA EL DROPDOWNLIST (SELECT) */
        .form-group select.form-control { /* Aplica solo a los elementos <select> con la clase form-control */
            appearance: none; /* Elimina estilos predeterminados de select en algunos navegadores */
            -webkit-appearance: none;
            -moz-appearance: none;
            /* La imagen de la flecha blanca para el desplegable */
            background-image: url('data:image/svg+xml;charset=US-ASCII,%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20width%3D%22292.4%22%20height%3D%22292.4%22%3E%3Cpath%20fill%3D%22%23ffffff%22%20d%3D%22M287%2069.4a17.6%2017.6%200%200%200-13.6-6.4H18.8c-5%200-9.3%201.8-12.9%205.4L1.4%2073.4c-1.8%201.8-2.6%204-2.6%206.4s.8%204.6%202.6%206.4l130.6%20130.6c3.6%203.6%207.8%205.4%2012.8%205.4s9.2-1.8%2012.8-5.4L291%2086.2c1.8-1.8%202.6-4%202.6-6.4s-.8-4.6-2.6-6.4z%22%2F%3E%3C%2Fsvg%3E');
            background-repeat: no-repeat;
            background-position: right 10px top 50%;
            background-size: 12px auto;
        }

        /* Estilos de foco, aplica a ambos tipos de control */
        .form-group .form-control:focus,
        .form-group select:focus {
            outline: none;
            box-shadow: 0 0 0 2px #007bff;
        }

        .btn-register {
            background-color: #007bff;
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
            color: #ff4d4d;
            font-size: 14px;
            margin-top: 5px;
            display: block;
        }
    </style>

     <div class="register-sede-container">
         <h2 id="formTitle" runat="server">Registrar Nueva Sede </h2>
             <!--Registrar Nueva Sede
             <asp:Label ID="lblTitulo" runat="server" Text="Label"></asp:Label>-->
        
         <!--distrito-->
         <div class="form-group">
             <label for="ddlDistrito">Distrito:</label>
             <asp:DropDownList ID="ddlDistrito" runat="server" CssClass="form-control">
                 <asp:ListItem Text="-- Seleccione un distrito --" Value="" />
                 <asp:ListItem Text="San Isidro" Value="San Isidro" />
                 <asp:ListItem Text="Miraflores" Value="Miraflores" />
                 <asp:ListItem Text="La Molina" Value="La Molina" />
                 <asp:ListItem Text="Jesús María" Value="Jesús María" />
                 <asp:ListItem Text="Magdalena del Mar" Value="Magdalena del Mar" />
                 <asp:ListItem Text="Comas" Value="Comas" />
                 <asp:ListItem Text="Los Olivos" Value="Los Olivos" />
                 </asp:DropDownList>
             <asp:RequiredFieldValidator ID="rfrDistrito" runat="server" ControlToValidate="ddlDistrito" InitialValue=""
                 ErrorMessage="El distrito es obligatorio." CssClass="validation-message"></asp:RequiredFieldValidator>
        
         </div>
         <!--direccion-->
         <div class="form-group">
             <label for="txtDireccion">Dirección:</label>
             <asp:TextBox ID="txtDireccion" runat="server" CssClass="form-control" Placeholder="Ingresa la dirección" />
             <asp:RequiredFieldValidator ID="rfvDireccion" runat="server" ControlToValidate="txtDireccion"
                 ErrorMessage="La dirección es obligatoria." CssClass="validation-message" />
         </div>
         <!--academia-->
         <div class="form-group">
             <label for="ddlAcademia">Academia:</label>
             <asp:DropDownList ID="ddlAcademia" runat="server" CssClass="form-control"    
                 AutoPostBack="true">
                 </asp:DropDownList>
             <asp:RequiredFieldValidator ID="rfvAcademia" runat="server" ControlToValidate="ddlAcademia" InitialValue=""
                 ErrorMessage="La sede es obligatoria." CssClass="validation-message"></asp:RequiredFieldValidator>
         </div>
     

         <asp:Button ID="btnRegistrar" runat="server" Text="Registrar Sede" CssClass="btn-register" OnClick="btnRegistrar_Click" />

          <asp:HiddenField ID="hdnSedeId" runat="server" Value="0" /> 

     </div>

</asp:Content>
