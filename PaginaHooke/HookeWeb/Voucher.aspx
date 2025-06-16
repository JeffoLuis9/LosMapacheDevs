<%@ Page Title="" Language="C#" MasterPageFile="~/SiteAdministrador.Master" AutoEventWireup="true" CodeBehind="Voucher.aspx.cs" Inherits="PUCP.Edu.Pe.Prog03HookeWeb.Web.Voucher" %>
<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
    Voucher del Alumno
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
            max-width: 600px; /* Ancho máximo para el formulario */
            margin: 50px auto; /* Centra el contenedor y le da margen superior/inferior */
            box-sizing: border-box;
            color: white; /* Color de texto general */
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

        .form-control {
            width: calc(100% - 20px); /* Ancho completo con padding */
            padding: 10px;
            border: 1px solid #444;
            border-radius: 5px;
            background-color: #333;
            color: white;
            font-size: 16px;
            box-sizing: border-box;
        }
        .form-control:focus {
            outline: none;
            border-color: #66afe9; /* Color de enfoque */
            box-shadow: 0 0 8px rgba(102, 175, 233, 0.6);
        }
        
        /* Estilos para campos deshabilitados (solo lectura) */
        .form-control[disabled] {
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
            text-decoration: none; /* Para LinkButton */
            display: inline-block; /* Para LinkButton */
        }

        .btn-primary {
            background-color: #007bff; /* Azul */
            color: white;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }

        .btn-secondary {
            background-color: #6c757d; /* Gris */
            color: white;
        }
        .btn-secondary:hover {
            background-color: #5a6268;
        }
    </style>

    <div class="form-container">
        <h2>Registro de Voucher</h2>

        <div class="form-group">
            <label for="<%= txtCodigoVoucher.ClientID %>">Código de Voucher:</label>
            <asp:TextBox ID="txtCodigoVoucher" runat="server" CssClass="form-control" MaxLength="50"></asp:TextBox>
            <asp:RequiredFieldValidator ID="rfvCodigoVoucher" runat="server" ControlToValidate="txtCodigoVoucher"
                ErrorMessage="El código de voucher es obligatorio." ForeColor="Red" Display="Dynamic"></asp:RequiredFieldValidator>
        </div>

        <div class="form-group">
            <label for="<%= txtMonto.ClientID %>">Monto:</label>
            <asp:TextBox ID="txtMonto" runat="server" CssClass="form-control" TextMode="Number" Step="0.01" min="0"></asp:TextBox>
            <asp:RequiredFieldValidator ID="rfvMonto" runat="server" ControlToValidate="txtMonto"
                ErrorMessage="El monto es obligatorio." ForeColor="Red" Display="Dynamic"></asp:RequiredFieldValidator>
            <asp:CompareValidator ID="cvMonto" runat="server" ControlToValidate="txtMonto" Type="Double"
                Operator="DataTypeCheck" ErrorMessage="Ingrese un monto válido." ForeColor="Red" Display="Dynamic"></asp:CompareValidator>
        </div>

        <div class="button-group">
            <asp:Button ID="btnAccion" runat="server" Text="Registrar" OnClick="btnAccion_Click" CssClass="btn btn-primary" />
            <asp:Button ID="btnCancelar" runat="server" Text="Cancelar" OnClick="btnCancelar_Click" CssClass="btn btn-secondary" CausesValidation="False" />
        </div>

   
    </div>
</asp:Content>
