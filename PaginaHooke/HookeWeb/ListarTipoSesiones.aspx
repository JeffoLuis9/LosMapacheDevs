<%@ Page Title="" Language="C#" MasterPageFile="~/SiteAdministrador.Master" AutoEventWireup="true" CodeBehind="ListarTipoSesiones.aspx.cs" Inherits="PUCP.Edu.Pe.Prog03HookeWeb.Web.ListarTipoSesiones" %>
<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
    Mostrar Tipo de Sesión
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
     <style>
        /* Reutiliza los mismos estilos genéricos que en ListarCurso.aspx */
        .list-container { 
            background-color: #1a1a1a;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
            width: 100%;
            max-width: 700px; /* Ajusta según el ancho deseado */
            box-sizing: border-box;
            margin: 20px auto;
            text-align: center;
        }
        .list-container h2 {
            color: white;
            margin-bottom: 20px;
            font-size: 28px;
            float: left;
        }
        .header-section {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        .header-section h2 {
            color: white;
            font-size: 28px;
            margin: 0;
            padding: 0;
        }
        .btn-add-new {
            background-color: #28a745;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
            text-decoration: none;
            display: inline-block;
            margin-bottom: 20px;
            transition: background-color 0.3s;
            float: right;
        }
        .btn-add-new:hover { background-color: #218838; }
        .list-container::after { content: ""; display: table; clear: both; }

        /* Estilos del GridView */
        .gvStyle {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        .gvStyle th {
            background-color: #333;
            color: white;
            padding: 12px 15px;
            text-align: center;
            border-bottom: 1px solid #555;
        }
        .gvStyle td {
            padding: 10px 15px;
            border-bottom: 1px solid #444;
            color: #ccc;
            text-align: left;
        }
        .gvStyle tr:nth-child(even) { background-color: #222; }
        .gvStyle tr:hover { background-color: #383838; }
        .gvStyle .gv-action-buttons { text-align: center; }
        .gvStyle .btn-modificar {
            background-color: #007bff;
            color: white;
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-right: 5px;
            text-decoration: none;
        }
        .gvStyle .btn-modificar:hover { background-color: #0056b3; }
        .gvStyle .btn-eliminar {
            background-color: #dc3545;
            color: white;
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
        }
        .gvStyle .btn-eliminar:hover { background-color: #c82333; }
        .empty-grid-message { text-align: center; padding: 20px; color: #aaa; font-style: italic; }
    </style>

    <div class="list-container">
        <div class="header-section">
            <h2>Lista de Tipos de Sesión</h2>
            <asp:LinkButton ID="btnRegistrarNuevo" runat="server" Text="Registrar" 
                CssClass="btn-add-new" OnClick="btnRegistrarNuevo_Click" />
        </div>
        
        <asp:GridView ID="gvTipoSesion" runat="server" AutoGenerateColumns="False" 
            DataKeyNames="idModalidad" CssClass="gvStyle"
            OnRowCommand="gvTipoSesion_RowCommand"
            EmptyDataText="No hay tipos de sesión registrados aún.">
            <Columns>
                <asp:BoundField DataField="tipo" HeaderText="Tipo de Sesión" ItemStyle-HorizontalAlign="Left" HeaderStyle-HorizontalAlign="Left" />
                <asp:BoundField DataField="precio" HeaderText="Precio" DataFormatString="{0:C}" ItemStyle-HorizontalAlign="Right" HeaderStyle-HorizontalAlign="Right" />


                <asp:TemplateField HeaderText="Acciones" ItemStyle-CssClass="gv-action-buttons">
                    <ItemTemplate>
                        <asp:LinkButton ID="lnkModificar" runat="server" CommandName="ModificarTipoSesion" 
                            CommandArgument='<%# Eval("idModalidad") %>' CssClass="btn-modificar">Modificar</asp:LinkButton>
                        <asp:LinkButton ID="lnkEliminar" runat="server" CommandName="EliminarTipoSesion" 
                            CommandArgument='<%# Eval("idModalidad") %>' CssClass="btn-eliminar"
                            OnClientClick='return confirm("¿Estás seguro de que quieres eliminar este tipo de sesión?");'>Eliminar</asp:LinkButton>
                    </ItemTemplate>
                </asp:TemplateField>
            </Columns>
            <EmptyDataRowStyle CssClass="empty-grid-message" />
        </asp:GridView>
    </div>
</asp:Content>
