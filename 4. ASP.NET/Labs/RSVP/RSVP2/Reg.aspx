<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Reg.aspx.cs" Inherits="RSVP2.Reg" MasterPageFile="~/Site.Master" trace="true" %>
<asp:Content ID="MainContent" ContentPlaceHolderID="ContentPlaceHolder1"  runat="server"  > 
    <div>
            <h1>Приглашаем на семинар</h1>
            <p></p>
        </div>
        <div> 
            <label>Ваше имя:</label>
            <asp:TextBox ID="name" runat="server"></asp:TextBox> 
    
            <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ControlToValidate="name" ErrorMessage="Заполните поле имени" ForeColor="#CC0000" Display="Dynamic" >Не оставляйте поле пустым</asp:RequiredFieldValidator>
    
        </div> 
        <div> 
            <label>Ваш email:</label>
            <asp:TextBox ID="email" runat="server"></asp:TextBox> 
            <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" ControlToValidate="email" ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*" ErrorMessage="E-mail is not in a valid format" Display="Dynamic" ForeColor="Red">Адрес введен неверно!!!</asp:RegularExpressionValidator>
            <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="Заполните поле по имени" ControlToValidate="email" ForeColor="#CC0000" SetFocusOnError="True" ValidateRequestMode="Enabled" ViewStateMode="Enabled">Не оставляйте поле пустым</asp:RequiredFieldValidator>
        </div>
        <div>
             <label>Ваш телефон:</label><asp:TextBox ID="phone" runat="server"></asp:TextBox>
             <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ControlToValidate="phone" ErrorMessage="Заполните поле " ForeColor="#CC0000">Не оставляйте поле пустым</asp:RequiredFieldValidator>
        </div>
        <div> 
            <label>Вы будете делать доклад?</label>
            <asp:CheckBox ID="CheckBoxYN" runat="server" />
            <asp:ValidationSummary ID="ValidationSummary1" runat="server" ShowModelStateErrors="true"/> 
        </div>
    <div> Введите название доклада: <asp:TextBox ID="TextBoxTitle" runat="server" Width="345px"></asp:TextBox> </div>
    <div> Введите аннотацию доклада: <asp:TextBox ID="TextBoxTextAnnot" runat="server" Width="345px"></asp:TextBox> </div>
    <div> Введите название доклада: <asp:TextBox ID="TextBoxTitle2" runat="server" Width="345px"></asp:TextBox> </div>
    <div> Введите аннотацию доклада: <asp:TextBox ID="TextBoxTextAnnot2" runat="server" Width="345px"></asp:TextBox> </div>
        <div>
            <button type="submit">Отправить ответ на приглашение RSVP</button>
        </div>
</asp:Content>

        

