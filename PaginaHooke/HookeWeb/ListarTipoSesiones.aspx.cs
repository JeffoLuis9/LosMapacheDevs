
﻿using PUCP.Edu.Pe.Prog03HookeWeb.Web.HookeWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;

using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class ListarTipoSesiones : System.Web.UI.Page
    {

        private TipoSesionWSClient tipoSesionWS;
        private BindingList<tipoSesion> tipoSesiones;
        protected void Page_Load(object sender, EventArgs e)
        {
            tipoSesionWS = new TipoSesionWSClient(); 
            tipoSesiones = new BindingList<tipoSesion>(tipoSesionWS.listarTipoSesiones());
            gvTipoSesion.DataSource = tipoSesiones;

            gvTipoSesion.DataBind();
        }

        protected void btnRegistrarNuevo_Click(object sender, EventArgs e)
        {
            Response.Redirect("RegistrarTipoSesion.aspx");
        }

        protected void gvTipoSesion_RowCommand(object sender, GridViewCommandEventArgs e)
        {

            int idModalidad = Convert.ToInt32(e.CommandArgument);
            if (e.CommandName == "ModificarTipoSesion")
            {
                Response.Redirect($"RegistrarTipoSesion.aspx?id={idModalidad}");
            }
            if (e.CommandName == "EliminarTipoSesion")
            {
                tipoSesionWS.eliminarTipoSesion(idModalidad);
                Response.Redirect("ListarTipoSesiones.aspx");
            }
        }

    }
}