<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="GestionarProfesores.aspx.cs" Inherits="PUCP.Edu.Pe.Prog03HookeWeb.Web.GestionarProfesores" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestionar Profesor
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>
                    <asp:Label ID="lblTitulo" runat="server" Text="Nuevo Profesor"></asp:Label>
                </h2>
            </div>
            <div class="card-body">
                <!-- ID Profesor -->
                <div class="mb-3 row">
                    <asp:Label ID="lblIDProfesor" runat="server" Text="ID Profesor:" CssClass="col-sm-2 col-form-label"></asp:Label>
                    <div class="col-sm-4">
                        <asp:TextBox ID="txtIDProfesor" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>

                <!-- Nombre -->
                <div class="mb-3 row">
                    <asp:Label ID="lblNombre" runat="server" Text="Nombre:" CssClass="col-sm-2 col-form-label"></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>

                <!-- Apellido -->
                <div class="mb-3 row">
                    <asp:Label ID="lblApellido" runat="server" Text="Apellido:" CssClass="col-sm-2 col-form-label"></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox ID="txtApellido" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>

                <!-- DNI -->
                <div class="mb-3 row">
                    <asp:Label ID="lblDNI" runat="server" Text="DNI:" CssClass="col-sm-2 col-form-label"></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox ID="txtDNI" runat="server" CssClass="form-control" MaxLength="8"></asp:TextBox>
                    </div>
                </div>

                <!-- Correo -->
                <div class="mb-3 row">
                    <asp:Label ID="lblEmail" runat="server" Text="Email:" CssClass="col-sm-2 col-form-label"></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox ID="txtEmail" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>

                <!-- Fecha de Nacimiento -->
                <div class="mb-3 row">
                    <asp:Label ID="lblFechaNacimiento" runat="server" Text="Fecha Nacimiento:" CssClass="col-sm-2 col-form-label"></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox ID="txtFechaNacimiento" runat="server" CssClass="form-control" placeholder="yyyy-MM-dd"></asp:TextBox>
                        <!-- O puedes usar un CalendarExtender si quieres -->
                    </div>
                </div>
            </div>

            <div class="card-footer">
                <asp:Button ID="btnGuardar" CssClass="float-end btn btn-primary" runat="server" Text="Guardar" OnClick="btnGuardar_Click" />
            </div>
        </div>
    </div>
</asp:Content>
