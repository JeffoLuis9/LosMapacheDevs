using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class Intenciones : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            DataTable dtAlumnos = new DataTable();

            // 2. Definir las columnas del DataTable
            dtAlumnos.Columns.Add("idUsuario", typeof(int));
            dtAlumnos.Columns.Add("NombreCompleto", typeof(string));
            dtAlumnos.Columns.Add("DNI", typeof(string));

            // 3. Añadir filas de datos de ejemplo
            dtAlumnos.Rows.Add(101, "Ana García", "12345678");
            dtAlumnos.Rows.Add(102, "Luis Ramírez", "87654321");
            dtAlumnos.Rows.Add(103, "María Fernández", "11223344");
            dtAlumnos.Rows.Add(104, "Pedro González", "55667788");
            dtAlumnos.Rows.Add(105, "Sofía Díaz", "99001122");

            // 4. Asignar el DataTable como DataSource del GridView
            gvAlumnos.DataSource = dtAlumnos;
            // 5. Enlazar los datos
            gvAlumnos.DataBind();
        }

        protected void gvAlumnos_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            if (e.CommandName == "VerCursos")
            {
                int idAlumno = Convert.ToInt32(e.CommandArgument);
                // CAMBIO CLAVE: Redirigir a la pantalla de cursos asignados en la MISMA pestaña
                Response.Redirect($"CursosIntencionAlumno.aspx?id={idAlumno}");
            }
        }
    }
}