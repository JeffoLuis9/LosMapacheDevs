<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="ListarProfesores.aspx.cs" Inherits="PUCP.Edu.Pe.Prog03HookeWeb.Web.ListarProfesores" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Listar Profesores
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h1>Lista de Profesores</h1>
    <p>Aquí puedes ver todos los profesores registrados en el sistema.</p>

    <!-- Botón para registrar nuevo profesor -->
    <div class="text-end mb-3">
        <asp:LinkButton 
            ID="lbRegistrar" 
            CssClass="btn btn-success" 
            runat="server" 
            OnClick="lbRegistrar_Click">
            <i class="fa-solid fa-plus"></i> Registrar Profesor
        </asp:LinkButton>
    </div>

    <!-- Tabla de profesores -->
    <div class="table-responsive">
        <asp:GridView 
            ID="gvProfesores" 
            runat="server" 
            AutoGenerateColumns="false"
            CssClass="table table-hover table-striped"
            PageSize="5" 
            AllowPaging="true" 
            OnPageIndexChanging="gvProfesores_PageIndexChanging">
            <Columns>
                <asp:BoundField HeaderText="ID" DataField="id" />
                <asp:BoundField HeaderText="Nombre" DataField="nombre" />
                <asp:BoundField HeaderText="Apellido" DataField="apellido" />
                <asp:BoundField HeaderText="Email" DataField="email" />
                <asp:TemplateField HeaderText="Acciones">
                    <ItemTemplate>
                        <asp:LinkButton 
                            runat="server" 
                            CssClass="btn btn-outline-primary btn-sm" 
                            Text="<i class='fa-solid fa-edit'></i>" 
                            CommandArgument='<%# Eval("id") %>' 
                            OnClick="lbModificar_Click" 
                            ToolTip="Modificar" />
                        <asp:LinkButton 
                            runat="server" 
                            CssClass="btn btn-outline-danger btn-sm" 
                            Text="<i class='fa-solid fa-trash'></i>" 
                            CommandArgument='<%# Eval("id") %>' 
                            OnClick="lbEliminar_Click" 
                            OnClientClick="return confirm('¿Estás seguro de eliminar este profesor?');" 
                            ToolTip="Eliminar" />
                    </ItemTemplate>
                </asp:TemplateField>
            </Columns>
        </asp:GridView>
    </div>

</asp:Content>
