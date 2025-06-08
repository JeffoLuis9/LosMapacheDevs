<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Matricula.aspx.cs" Inherits="PUCP.Edu.Pe.Prog03HookeWeb.Web.Matricula" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Matricula
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container mt-4">    
        <h2>Matricula</h2>

        <div class="row mb-3">
            
            <div class="col-md-6">
                <label for="TxtNivel">Nivel del Alumno:</label>
                <div class="input-group">
                    <asp:TextBox ID="TxtNivel" runat="server" CssClass="form-control"></asp:TextBox>
                    <div class="input-group-append">
                        <asp:Button ID="BtnBuscarCursos" runat="server" Text="Buscar"
                            CssClass="btn btn-primary" OnClick="BtnBuscarCursos_Click" />
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <label for="TxtModalidad">Modalidad:</label>
                <div class="input-group">
                    <asp:TextBox ID="TxtModalidad" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>

            <div class="col-md-6">
                <label for="DdlCursos">Cursos:</label>
                <asp:DropDownList ID="DdlCursos" runat="server" CssClass="form-select" 
                    AutoPostBack="true" 
                    OnSelectedIndexChanged="DdlCursos_SelectedIndexChanged">
                        
                </asp:DropDownList>
            </div>

            <div class="col-md-6">
                <label for="DdlProfesores">Profesores:</label>
                <asp:DropDownList ID="DdlProfesores" runat="server" CssClass="form-select">
                </asp:DropDownList>
            </div>

            <div class="col-md-6">
                <label for="DdlTipoSesion">Tipo de Sesión:</label>
                <asp:DropDownList ID="DdlTipoSesion" runat="server" CssClass="form-select">
                </asp:DropDownList>
            </div>

            <div class="col-md-6">
                <label for="DdlSede">Sede:</label>
                <asp:DropDownList ID="DdlSede" runat="server" CssClass="form-select">
                </asp:DropDownList>
            </div>


        </div>
        <div class="row">
        <div class="col-md-12">
            <asp:Button ID="BtnRegistrar" runat="server" Text="Registrar Matrícula" CssClass="btn btn-success"
                OnClick ="BtnRegistrar_Click"/>
            <asp:Label ID="LblMensaje" runat="server" CssClass="ml-3"></asp:Label>
        </div>
</div>        
    </div>
</asp:Content>
