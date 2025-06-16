using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class Voucher : System.Web.UI.Page
    {
        protected void Page_PreInit(object sender, EventArgs e)
        {
            // Lógica para establecer la Master Page dinámicamente según el rol


            string userRole = Session["Rol"].ToString();

            if (userRole == "Administrador")
            {
                this.MasterPageFile = "~/SiteAdministrador.Master";
            }
            else
            {
                this.MasterPageFile = "~/SiteAlumno.Master"; // Usar la Master Page del alumno
            }

        }
        protected void Page_Load(object sender, EventArgs e)
        {
            string userRole = Session["Rol"].ToString();
            if (userRole == "Administrador")
            {
                txtCodigoVoucher.Enabled = false; // Deshabilita los campos para el administrador
                txtMonto.Enabled = false;
                btnAccion.Text = "Confirmar"; // Cambia el texto del botón

            }
            else if (userRole == "Estudiante")
            {
                txtCodigoVoucher.Enabled = true; // Habilita los campos para el estudiante
                txtMonto.Enabled = true;
                btnAccion.Text = "Registrar"; // Texto del botón para el estudiante

            }
        }

        protected void btnAccion_Click(object sender, EventArgs e)
        {
            Response.Redirect("CursosIntencionAlumno.aspx");
        }

        protected void btnCancelar_Click(object sender, EventArgs e)
        {
            Response.Redirect("CursosIntencionAlumno.aspx");
        }
    }
}