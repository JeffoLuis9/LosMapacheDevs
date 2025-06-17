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
        private SedeWSClient sedeWS;
        private AcademiaWSClient academiaWS;
        private BindingList<academia> academias;

        public GestionarSede()
        {
            this.sedeWS = new SedeWSClient();
        }

        protected void Page_Init(object sender, EventArgs e)
        {

            academiaWS = new AcademiaWSClient();
            academias = new BindingList<academia>(academiaWS.listarAcademias());

            ddlAcademia.DataSource = academias;
            ddlAcademia.DataValueField = "id";
            ddlAcademia.DataTextField = "nombre";
            ddlAcademia.DataBind();
            ddlAcademia.Items.Insert(0, new ListItem("-- Seleccione Academia --", ""));

            if (Request.QueryString["id"] != null)
            {
                //modificar TODO ESTO
                int sedeId;
                if (int.TryParse(Request.QueryString["id"], out sedeId))
                {
                    sedeWS = new SedeWSClient();
                    sede = sedeWS.obtenerSede(sedeId);
                    estado = estado.Modificar;
                    formTitle.InnerText = "Modificar Sede";
                    litPageTitle.Text = "Modificar Curso";
                    btnRegistrar.Text = "Guardar Sede";
                    ddlDistrito.Text = sede.distrito;
                    txtDireccion.Text = sede.direccion;
                    //revisar
                    ddlAcademia.SelectedValue = sede.academia.id.ToString();
                    
                }
            }
            else
            {
                estado = estado.Nuevo;
                hdnSedeId.Value = "0";
                formTitle.InnerText = "Registrar Sede";
                litPageTitle.Text = "Registrar Sede";
                btnRegistrar.Text = "Registrar Sede";
                sede = new sede();
            }



        }

       


        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            /*
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
            */

            academia academia = new academia();
            academiaWS=new AcademiaWSClient();
            sedeWS = new SedeWSClient();
            sede.direccion= txtDireccion.Text;
            sede.distrito= ddlDistrito.Text;
            //revisar
            academia = academiaWS.obtenerAcademia(Int32.Parse(ddlAcademia.SelectedValue));
            sede.academia = academia;
            // Llamada al servicio para guardar
            sedeWS.guardarSede(sede, estado);

            // Redireccionamos a listar
             Response.Redirect("ListarSede.aspx");



        }



    }
}