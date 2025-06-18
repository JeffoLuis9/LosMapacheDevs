<%@ Page Title="" Language="C#" MasterPageFile="~/SiteAdministrador.Master" AutoEventWireup="true" CodeBehind="ListarProfesor.aspx.cs" Inherits="PUCP.Edu.Pe.Prog03HookeWeb.Web.ListarProfesor" %>
<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
    Mostrar Profesores
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <style>
        /* Estilos para el contenedor principal (mantener como está) */
        .list-profesor-container {
            background-color: #1a1a1a;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
            width: 100%;
            max-width: 900px;
            margin: 20px auto;
            box-sizing: border-box;
        }

        /* Estilos para el encabezado con Flexbox (mantener como está) */
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
            transition: background-color 0.3s;
            margin: 0;
        }
        .btn-add-new:hover {
            background-color: #218838;
        }

        /* INICIO DE MODIFICACIONES CLAVE PARA LA GRILLA */

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

    <div class="list-profesor-container">
        <div class="header-section">
            <h2>Lista de Profesores</h2>
            <asp:LinkButton ID="btnRegistrarNuevo" runat="server" Text="Registrar" 
                CssClass="btn-add-new" OnClick="btnRegistrarNuevo_Click" />
        </div>
        
        <asp:GridView ID="gvProfesores" runat="server" AutoGenerateColumns="False" 

            DataKeyNames="id" CssClass="gvStyle"
            OnRowCommand="gvProfesores_RowCommand"
            EmptyDataText="No hay profesores registrados aún.">
            <Columns>
                <asp:TemplateField HeaderText="Nombre del Profesor">
                    <ItemTemplate>
                        <%# Eval("nombre") %> <%# Eval("apellido") %>
                    </ItemTemplate>
                    <ItemStyle HorizontalAlign="Left" />
                    <HeaderStyle HorizontalAlign="Left" />
                </asp:TemplateField>

                <%-- Columna para Nombre del Curso --%>
                <asp:TemplateField HeaderText="Curso Asignado">
                    <ItemTemplate>
                        <%# Eval("curso.nombre") %>
                    </ItemTemplate>
                    <ItemStyle HorizontalAlign="Left" />
                    <HeaderStyle HorizontalAlign="Left" />
                </asp:TemplateField>

                
                <asp:TemplateField HeaderText="Acciones">
                    <ItemTemplate>
                        <asp:LinkButton ID="lnkModificar" runat="server" CommandName="ModificarProfesor" 

                            CommandArgument='<%# Eval("id") %>' CssClass="btn-modificar">Modificar</asp:LinkButton>
                        <asp:LinkButton ID="lnkEliminar" runat="server" CommandName="EliminarProfesor" 
                            CommandArgument='<%# Eval("id") %>' CssClass="btn-eliminar"

                            OnClientClick='return confirm("¿Estás seguro de que quieres eliminar a este profesor?");'>Eliminar</asp:LinkButton>
                    </ItemTemplate>
                    <ItemStyle CssClass="gv-action-buttons" />
                </asp:TemplateField>
            </Columns>
            <EmptyDataRowStyle CssClass="empty-grid-message" />
        </asp:GridView>
    </div>
</asp:Content>
