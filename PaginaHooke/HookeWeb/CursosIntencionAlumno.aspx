<%@ Page Title="" Language="C#" MasterPageFile="~/SiteAdministrador.Master" AutoEventWireup="true" CodeBehind="CursosIntencionAlumno.aspx.cs" Inherits="PUCP.Edu.Pe.Prog03HookeWeb.Web.CursosIntencionAlumno" %>
<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
        Cursos de Alumno
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

        /* Estilos del encabezado (título y un posible botón de volver) */
        .header-section {
            display: flex;
            justify-content: space-between; /* Para alinear el título y el botón "Volver" */
            align-items: center;
            margin-bottom: 20px;
        }
        .header-section h2 {
            color: white;
            font-size: 28px;
            margin: 0;
            padding: 0;
        }
        /* Estilo para el botón de "Volver", si lo incluyes */
        .btn-volver {
            background-color: #6c757d; /* Gris para un botón de volver */
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
        .btn-volver:hover {
            background-color: #5a6268;
        }

        /* Estilos del GridView (clase gvStyle) - Reutilizando estilos existentes */
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
        .gvStyle .btn-voucher { /* Nuevo estilo para el botón "Voucher" */
            background-color: #ffc107; /* Amarillo/naranja */
            color: black; /* Texto oscuro para contrastar con amarillo */
            padding: 6px 12px;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s;
            display: inline-block;
        }
        .gvStyle .btn-voucher:hover {
            background-color: #e0a800;
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
            <h2>Cursos del Alumno: <asp:Literal ID="litNombreAlumno" runat="server"></asp:Literal></h2>
        </div>
        
        <asp:GridView ID="gvCursosAlumno" runat="server" AutoGenerateColumns="False" 
            DataKeyNames="idInscripcion"
            CssClass="gvStyle"
            OnRowCommand="gvCursosAlumno_RowCommand"
            EmptyDataText="No hay cursos inscritos para este alumno.">
            <Columns>
                <asp:BoundField DataField="NombreCurso" HeaderText="Nombre del Curso" ItemStyle-HorizontalAlign="Left" HeaderStyle-HorizontalAlign="Left" />
                <asp:BoundField DataField="NombreProfesor" HeaderText="Profesor" ItemStyle-HorizontalAlign="Left" HeaderStyle-HorizontalAlign="Left" />
                <asp:BoundField DataField="Intencion" HeaderText="Intención" ItemStyle-HorizontalAlign="Left" HeaderStyle-HorizontalAlign="Left" />
                
                <asp:TemplateField HeaderText="Voucher">
                    <ItemTemplate>
                        <asp:LinkButton ID="lnkVoucher" runat="server" 
                            CommandName="VerVoucher" 
                            CommandArgument='<%# Eval("idInscripcion") %>' 
                            Text="Voucher"
                            CssClass='<%# Eval("Intencion").ToString() == "Aceptado" ? "btn-voucher-disabled" : "btn-voucher" %>'
                            Enabled='<%# Eval("Intencion").ToString() != "Aceptado" %>'>
                        </asp:LinkButton>
                    </ItemTemplate>
                    <ItemStyle CssClass="gv-action-buttons" />
                </asp:TemplateField>
            </Columns>
            <EmptyDataRowStyle CssClass="empty-grid-message" />
        </asp:GridView>
    </div>
</asp:Content>
