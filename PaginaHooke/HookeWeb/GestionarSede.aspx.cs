using PUCP.Edu.Pe.Prog03HookeWeb.Web.HookeWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class GestionarSede : System.Web.UI.Page
    {
        private sede sede;

        
        private estado estado;
        private readonly SedeWSClient sedeWS;


        
        private AcademiaWSClient academiaWS;
        private BindingList<academia> academias;

        public GestionarSede()
        {
            this.sedeWS = new SedeWSClient();
        }

        protected void Page_Init(object sender, EventArgs e)
        {
            string accion = Request.QueryString["accion"];
            if (accion == null)
            {
                lblTitulo.Text = "Registrar Sedes";
                sede = new sede();
                estado = estado.Nuevo;
                if (!IsPostBack)
                {
                    Session["sede"] = null;
                }
            }
            else if (accion == "modificar" && Session["sede"] != null)
            {
                lblTitulo.Text = "Modificar sede";
                estado = estado.Modificar;
                sede = (sede)Session["sede"];

                ddlDistrito.Text = sede.distrito;
                txtDireccion.Text = sede.direccion;
                ddlAcademia.SelectedValue = sede.academia.id.ToString();
            }
        }

        protected void DdlAcademia_SelectedIndexChanged(object sender, EventArgs e)
        {    
                academiaWS = new AcademiaWSClient();
                academias = new BindingList<academia>(academiaWS.listarAcademias());

                ddlAcademia.DataSource = academias;
                ddlAcademia.DataValueField = "id";
                ddlAcademia.DataTextField = "nombre";
                ddlAcademia.DataBind();
            
        }


        protected void btnRegistrar_Click(object sender, EventArgs e)
        {

            academia academia = academiaWS.obtenerAcademia(1);
            // Asignamos los valores
            sede sedeguardar = new sede();
            if (estado == estado.Nuevo)
            {
                sedeguardar.direccion = txtDireccion.Text;
                sedeguardar.distrito = ddlDistrito.Text;
                sedeguardar.academia = academia;
            }
            else
            {
                //errror no sé como guardar el id si no existe la sede
                //sedeguardar.id = int.Parse(txtIDProfesor.Text);
                sedeguardar.direccion = txtDireccion.Text;
                sedeguardar.distrito = ddlDistrito.Text;
                sedeguardar.academia = academia;
            }

            // Llamada al servicio para guardar
            sedeWS.guardarSede(sedeguardar, estado);

            // Redireccionamos a listar
             Response.Redirect("ListarSede.aspx");
        }



    }
}