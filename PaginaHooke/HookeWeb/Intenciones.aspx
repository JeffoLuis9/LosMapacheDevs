<%@ Page Title="" Language="C#" MasterPageFile="~/SiteAdministrador.Master" AutoEventWireup="true" CodeBehind="Intenciones.aspx.cs" Inherits="PUCP.Edu.Pe.Prog03HookeWeb.Web.Intenciones" %>
<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
    Alumnos
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <style>
        /* Estilos generales del contenedor */
        .list-container {
            background-color: #1a1a1a;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
            width: 100%;
            max-width: 900px;
            margin: 20px auto;
            box-sizing: border-box;
        }

        /* Estilos del encabezado (solo el título ahora) */
        .header-section {
            display: flex; /* Mantenemos flexbox por si en el futuro se añade algo más, pero ahora solo habrá un elemento */
            justify-content: flex-start; /* Alinea el título a la izquierda */
            align-items: center;
            margin-bottom: 20px;
        }
        .header-section h2 {
            color: white;
            font-size: 28px;
            margin: 0;
            padding: 0;
        }
        /* Eliminamos los estilos para .btn-add-new ya que no lo usaremos */

        /* Estilos del GridView (clase gvStyle) - Sin cambios aquí */
        .gvStyle {
            width: 100%;
            border-collapse: collapse;
            margin-top: 0; 
        }
        .gvStyle th {
            background-color: #333;
            color: white;
            padding: 12px 15px;
            text-align: center;
            border-bottom: 1px solid #555;
            border-right: 1px solid #555;
        }
        .gvStyle th:last-child { 
            border-right: none; 
        }

        .gvStyle td {
            background-color: #2a2a2a;
            color: #ccc;
            padding: 10px 15px;
            border-bottom: 1px solid #444;
            border-right: 1px solid #444;
            text-align: left;
        }
        .gvStyle td:last-child { 
            border-right: none; 
        }

        .gvStyle tr:nth-child(even) td { 
            background-color: #222; 
        }
        .gvStyle tr:hover td { 
            background-color: #383838; 
        }

        /* Estilos para los botones de acción dentro de la grilla */
        .gvStyle .gv-action-buttons {
            text-align: center;
            padding: 5px;
        }
        .gvStyle .btn-cursos {
            background-color: #007bff;
            color: white;
            padding: 6px 12px;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s;
            display: inline-block;
            margin: 0 auto;
        }
        .gvStyle .btn-cursos:hover {
            background-color: #0056b3;
        }
        
        .empty-grid-message {
            color: #ccc;
            padding: 20px;
            font-style: italic;
            text-align: center;
        }
    </style>

    <div class="list-container">
        <div class="header-section">
            <h2>Lista de Alumnos</h2>
            <%-- Eliminado: <asp:LinkButton ID="btnRegistrarNuevo" ... /> --%>
        </div>
        
        <asp:GridView ID="gvAlumnos" runat="server" AutoGenerateColumns="False" 
            DataKeyNames="idUsuario"
            CssClass="gvStyle"
            OnRowCommand="gvAlumnos_RowCommand"
            EmptyDataText="No hay alumnos registrados aún.">
            <Columns>
                <asp:BoundField DataField="NombreCompleto" HeaderText="Nombre Completo" ItemStyle-HorizontalAlign="Left" HeaderStyle-HorizontalAlign="Left" />
                <asp:BoundField DataField="DNI" HeaderText="DNI" ItemStyle-HorizontalAlign="Left" HeaderStyle-HorizontalAlign="Left" />
                
                <asp:TemplateField HeaderText="Acciones">
                    <ItemTemplate>
                       
                        <asp:LinkButton ID="lnkCursos" runat="server" 
                            CommandName="VerCursos"
                            CommandArgument='<%# Eval("idUsuario") %>'
                            CssClass="btn-cursos">Cursos</asp:LinkButton>
                    </ItemTemplate>
                    <ItemStyle CssClass="gv-action-buttons" />
                </asp:TemplateField>
            </Columns>
            <EmptyDataRowStyle CssClass="empty-grid-message" />
        </asp:GridView>
    </div>
</asp:Content>
