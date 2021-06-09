<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Start.aspx.cs" Inherits="RSVP2.Start" MasterPageFile="~/Site.master" %>
<asp:Content ID="MainContent" ContentPlaceHolderID="ContentPlaceHolder1"  runat="server"> 

    <div>
    <div class="rek"> <h1>Приглашение на семинар</h1>
                 <p>
                    <asp:ScriptManager ID="ScriptManager1" runat="server">
                    </asp:ScriptManager>
                </p>
                <p>Вы приглашены на наш семинар</p>
                <p>Подтвердите свое согласие, пройдя регистрацию</p> 
    </div> 
    <div class="info"> Семинар состоится 1 января 2021 года в 7.30 </div>
    </div>

         <asp:UpdatePanel ID="UpdatePanel1" runat="server" >
            <Triggers>
                   <asp:PostBackTrigger ControlID="timer1" />
            </Triggers> 
         </asp:UpdatePanel>
         <asp:Timer ID="timer1" runat="server" Interval="10000"> </asp:Timer>
         <%
        DateTime dataseminar = new DateTime(2022,1,1,7,30,0); 
        DateTime dnow = DateTime.Now; 
        int rd = (dataseminar - dnow).Days; 
        int rm = (dataseminar - dnow).Minutes; 
        int rsec = (dataseminar - dnow).Seconds; 
         %> 
      
        <h3>До семинара осталось <%=rd.ToString()%> дн., <%=rm.ToString()%> мин. и <%=rsec.ToString()%> с.</h3>
        <p>
            <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Button" Width="222px" Font-Size="Medium" BackColor="#FFCC00" BorderColor="Black" BorderStyle="Solid" />
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Button ID="Button2" runat="server" OnClick="Button2_Click" Text="Заполнить форму" Width="285px" />
        </p>
        <asp:Button ID="Button3" runat="server" OnClick="Button3_Click" Text="List" Width="223px" />
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="Button4" runat="server" OnClick="Button4_Click" Text="About" Width="286px" />
        </asp:Content>



        

