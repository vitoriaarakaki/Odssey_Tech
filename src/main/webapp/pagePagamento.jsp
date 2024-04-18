
    <!DOCTYPE html>
    <html lang="pt-br">
    
    <head>

        <%@ page contentType="text/html; charset=UTF-8" %>

        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/style.css">
        <link rel="stylesheet" href="./css/pagePagamento.css">
        <link rel="icon" href="https://cdn.discordapp.com/attachments/903692903518441473/975941397150580767/compras-online.png">
        <link rel="icon" href="./imgs/icons/logo carrinho-PhotoRoom.png">
        <link rel="icon" href="https://cdn.icon-icons.com/icons2/1993/PNG/512/account_avatar_face_man_people_profile_user_icon_123197.png">
    
    
        
    <title>carrinho</title>
    </head>
    
    <body>
        
            
            <div class="form">
                <form action="#">
                    <div class="form-header">
                        <div class="title">
                            <h1>Detalhes da Compra</h1>
                        </div>
                    </div>
    
                    <div class="input-group">
                        <div class="input-box">
                            <label for="firstname">Apelido do cartão</label>
                            <input id="firstname" type="text" name="firstname" placeholder="Digite seu primeiro nome" required>
                        </div>
    
                        <div class="input-box">
                            <label for="lastname">Nome no cartão</label>
                            <input id="lastname" type="text" name="lastname" placeholder="Digite seu sobrenome" required>
                        </div>
                        <div class="input-box">
                            <label for="email">CPF</label>
                            <input id="email" type="email" name="email" placeholder="Digite seu CPf" required>
                        </div>
    
                        <div class="input-box">
                            <label for="number">Numero do cartão</label>
                            <input id="number" type="tel" name="number" placeholder="Digite o numero do cartão" required>
                        </div>
    
                        <div class="input-box">
                            <label for="number">Data de validade do cartao</label>
                            <input type="date" id="data" name="dataIda">
                        </div>
    
                        <div class="input-box">
                            <label for="confirmPassword">CVV</label>
                            <input id="confirmPassword" type="password" name="confirmPassword" maxlength="3" placeholder="Digite o CVV do cartão" required  >
                        </div>
    
                       
    
    
                        
    
                    </div>
    
                    <div class="gender-inputs">
                        <div class="gender-title">
                            <h6>Formas de pagamento</h6>
                        </div>
    
                        <div class="gender-group">
                            <div class="gender-input">
                                <input id="female" type="radio" name="gender">
                                <label for="female">Credito</label>
                            </div>
    
                            <div class="gender-input">
                                <input id="male" type="radio" name="gender">
                                <label for="male">Debito </label>
                            </div>
    
                         
                                <div class="gender-input">
                                    <input id="female" type="radio" name="gender">
                                    <label for="female">Pix</label>
                                </div>
        
                                <div class="gender-input">
                                    <input id="male" type="radio" name="gender">
                                    <label for="male">Boleto </label>
                                </div>
        
                           
                        </div>
                    </div>
    
                    <div class="continue-button">
                        <button><a href="./index.jsp">Finalizar compra</a> </button>
                    </div>
                </form>
            </div>
        </div>
    </body>
    
    </html>
</body>
</html>