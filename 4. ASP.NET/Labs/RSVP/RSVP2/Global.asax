﻿<%@ Application Codebehind="Global.asax.cs" Inherits="RSVP2.Global" Language="C#" %>
<script runat="server">
    protected void Application_OnEndRequest() 
    { Response.Write("<hr />Эта страница была загружена " + DateTime.Now.ToString()); }
</script>
