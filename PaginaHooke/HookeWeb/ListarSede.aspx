<%@ Page Title="" Language="C#" MasterPageFile="~/SiteAdministrador.Master" AutoEventWireup="true" CodeBehind="ListarSede.aspx.cs" Inherits="PUCP.Edu.Pe.Prog03HookeWeb.Web.ListarSede" %>
<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
    Mostrar Sedes
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <style>
        /* Estilos generales para el contenedor */
        .list-container { /* Un nombre más genérico que 'list-profesor-container' */
            background-color: #1a1a1a;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
            width: 100%;
            max-width: 900px; /* Ajusta según el ancho deseado para tu grilla */
            box-sizing: border-box;
            margin: 20px auto;
            text-align: center;
        }
        .list-container h2 {
            color: white;
            margin-bottom: 20px;
            font-size: 28px;
            float: left; /* Flota el título a la izquierda */
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
        /* Estilo para el botón de registro, flotado a la derecha */
        .btn-add-new {
            background-color: #28a745; /* Verde */
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
            float: right; /* ¡Flota a la derecha! */
        }
        .btn-add-new:hover {
            background-color: #218838;
        }

        /* Clearfix para limpiar el float */
        .list-container::after {
            content: "";
            display: table;
            clear: both;
        }

        /* Estilos del GridView */
        .gvStyle { /* Un nombre de clase genérico para el GridView */
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px; /* Espacio para el título y botón */
        }
        .gvStyle th {
            background-color: #333;
            color: white;
            padding: 12px 15px;
            text-align: center; /* Centrar encabezados */
            border-bottom: 1px solid #555;
        }
        .gvStyle td {
            padding: 10px 15px;
            border-bottom: 1px solid #444;
            color: #ccc;
            text-align: left; /* Alineación predeterminada para celdas de datos */
        }
        .gvStyle tr:nth-child(even) {
            background-color: #222; /* Fila par */
        }
        .gvStyle tr:hover {
            background-color: #383838; /* Resaltar fila al pasar el mouse */
        }
        .gvStyle .gv-action-buttons {
            text-align: center; /* Centrar botones de acción */
        }
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
        .gvStyle .btn-modificar:hover {
            background-color: #0056b3;
        }
        .gvStyle .btn-eliminar {
            background-color: #dc3545;
            color: white;
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
        }
        .gvStyle .btn-eliminar:hover {
            background-color: #c82333;
        }
        .empty-grid-message {
            text-align: center;
            padding: 20px;
            color: #aaa;
            font-style: italic;
        }
    </style>

    <div class="list-container">
    <div class="header-section">
        <h2>Lista de Sedes</h2>
        <asp:LinkButton ID="btnRegistrarNuevo" runat="server" Text="Registrar" 
            CssClass="btn-add-new" OnClick="btnRegistrarNuevo_Click" />
    </div>
 
    <asp:GridView ID="gvSedes" runat="server" AutoGenerateColumns="False" 
        DataKeyNames="id" CssClass="gvStyle"
        OnRowCommand="gvSedes_RowCommand"
        EmptyDataText="No hay Sedes registradas aún.">
        <Columns>
            <asp:BoundField DataField="direccion" HeaderText="Direccion" ItemStyle-HorizontalAlign="Left" HeaderStyle-HorizontalAlign="Left" />
            <asp:BoundField DataField="distrito" HeaderText="Distrito" ItemStyle-HorizontalAlign="Left" HeaderStyle-HorizontalAlign="Left" />

            <asp:TemplateField HeaderText="Acciones" ItemStyle-CssClass="gv-action-buttons">
                <ItemTemplate>
                    <asp:LinkButton ID="lnkModificar" runat="server" CommandName="ModificarSede" 
                        CommandArgument='<%# Eval("id") %>' CssClass="btn-modificar">Modificar</asp:LinkButton>
                    <asp:LinkButton ID="lnkEliminar" runat="server" CommandName="EliminarSede" 
                        CommandArgument='<%# Eval("id") %>' CssClass="btn-eliminar"
                        OnClientClick='return confirm("¿Estás seguro de que quieres eliminar esta sede?");'>Eliminar</asp:LinkButton>
                </ItemTemplate>
            </asp:TemplateField>
        </Columns>
        <EmptyDataRowStyle CssClass="empty-grid-message" />
    </asp:GridView>
</div>


</asp:Content>
