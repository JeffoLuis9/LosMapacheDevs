<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="GestionarCurso.aspx.cs" Inherits="PUCP.Edu.Pe.Prog03HookeWeb.Web.GestionarCurso" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestionar Curso
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>
                    <asp:Label ID="lblTitulo" runat="server" Text="Label"></asp:Label>
                </h2>
            </div>
            <div class="card-body">
                <div class="mb-3 row">
                    <asp:Label id="lblNivel" runat="server" CssClass="col-sm-2 col-form-label" Text="Nivel: "></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox id="txtNivel" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>

                <div class="mb-3 row">
                    <asp:Label id="lblIdCurso" runat="server" CssClass="col-sm-2 col-form-label" Text="ID: "></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox id="txtIDCurso" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>

                <div class="mb-3 row">
                    <asp:Label id="lblCodigo" runat="server" CssClass="col-sm-2 col-form-label" Text="Codigo: "></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox id="txtCodigo" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>

                <div class="mb-3 row">
                    <asp:Label id="lblNombre" runat="server" CssClass="col-sm-2 col-form-label" Text="Nombre: "></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox id="txtNombre" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>


                <div class="mb-3 row">
                    <asp:Label id="LblHoraInicio" runat="server" CssClass="col-sm-2 col-form-label" Text="Hora Inicio: "></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox id="txtHoraInicio" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>


                <div class="mb-3 row">
                    <asp:Label id="lblHoraFin" runat="server" CssClass="col-sm-2 col-form-label" Text="Hora Fin: "></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox id="txtHoraFin" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>


            <div class="card-footer">
                <asp:Button id="btnGuardar" runat="server" CssClass="float-end btn btn-primary" Text="Guardar" OnClick="btnGuardar_Click"/>
            </div>
        </div>
    </div>
</div>
</asp:Content>
