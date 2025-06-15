<%@ Page Title="" Language="C#" MasterPageFile="~/SiteAdministrador.Master" AutoEventWireup="true" CodeBehind="ListarProfesor.aspx.cs" Inherits="PUCP.Edu.Pe.Prog03HookeWeb.Web.ListarProfesor" %>
<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
    Mostrar Profesores
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <style>
        /* Estilos para la grilla y botones */
        .list-profesor-container {
            background-color: #1a1a1a;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
            width: 100%;
            max-width: 900px; /* Ancho máximo para la grilla */
            margin: 20px auto;
            box-sizing: border-box;
            text-align: center;
        }
        .list-profesor-container h2 {
            color: white;
            margin-bottom: 30px;
            font-size: 28px;
        }

        /* Estilos del GridView */
        .gvProfesor {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        .gvProfesor th {
            background-color: #333;
            color: white;
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #555;
        }
        .gvProfesor td {
            background-color: #2a2a2a;
            color: white;
            padding: 10px 15px;
            border-bottom: 1px solid #444;
        }
        .gvProfesor tr:hover td {
            background-color: #3a3a3a;
        }
        .gvProfesor .gv-action-buttons a {
            display: inline-block;
            padding: 6px 12px;
            margin-right: 5px;
            border-radius: 5px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s;
        }
        .gvProfesor .btn-modificar {
            background-color: #007bff;
            color: white;
        }
        .gvProfesor .btn-modificar:hover {
            background-color: #0056b3;
        }
        .gvProfesor .btn-eliminar {
            background-color: #dc3545;
            color: white;
        }
        .gvProfesor .btn-eliminar:hover {
            background-color: #c82333;
        }
        .empty-grid-message {
            color: #ccc;
            margin-top: 20px;
            font-style: italic;
        }
    </style>

    <div class="list-profesor-container">
        <h2>Lista de Profesores</h2>

        <asp:GridView ID="gvProfesores" runat="server" AutoGenerateColumns="False" 
            DataKeyNames="idUsuario" CssClass="gvProfesor"
            OnRowDeleting="gvProfesores_RowDeleting" OnRowCommand="gvProfesores_RowCommand"
            EmptyDataText="No hay profesores registrados aún.">
            <Columns>
                <asp:BoundField DataField="NombreCompleto" HeaderText="Nombre del Profesor" />
                <asp:BoundField DataField="NombreCurso" HeaderText="Curso Asignado" />
                
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
