<!DOCTYPE html>
<html lang="pt-br">

<head>

    <%@ page contentType="text/html; charset=UTF-8"%>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="./css/subscribe.css" />
    <link rel="icon"
        href="https://cdn.icon-icons.com/icons2/1993/PNG/512/account_avatar_face_man_people_profile_user_icon_123197.png">

	
    <title>Cadastro</title>
</head>

<body>
    <div class="container">
        <div class="form-image">
            <div class="box">
                <span></span>
                <div class="content">
                    <h2>Ei, Conta pra gente um pouco sobre você!</h2>
                </div>
            </div>
        </div>
        <div class="form">
            <form method="post" action="cadastro">
                <div class="form-header">
                    <div class="title">
                        <h1>Cadastre-se</h1>
                    </div>
                </div>

                <div class="input-group">
                    <div class="input-box">
                        <label for="firstname">Nome Completo</label>
                        <input id="firstname" minlength="1" type="text" name="name" placeholder="Digite seu primeiro nome"
                            required>
                    </div>

                    
                    <div class="input-box">
                        <label for="email">E-mail</label>
                        <input id="email" type="email" name="email" placeholder="Digite seu e-mail" required>
                    </div>

                    <div class="input-box">
                        <label for="number">Celular</label>
                        <input id="number" minlength="11" maxlength="11" type="text" name="number" placeholder="(xx) xxxx-xxxx" required>
                    </div>

                    <div class="input-box">
                        <label for="number">Data de nascimento</label>
                        <input type="date" id="data" name="dataNasc"  required>
                    </div>

                    <div class="input-box">
                        <label for="confirmPassword">CPF</label>
                        <input id="confirmPassword" minlength="11" maxlength="11" type="text" name="cpf" placeholder="Digite seu CPF"
                            required>
                    </div>

                    <div class="input-box">
                        <label for="number">Usuario</label>
                        <input id="number" minlength="3" maxlength="10" type="text" name="usuario" placeholder="Digite seu user" required>
                    </div>

                    <div class="input-box">
                        <label for="password">Senha</label>
                        <input id="password" type="password" name="password" placeholder="Digite sua senha" required>
                    </div>
					
					<div class="continue-button">
                    	<button class="type="submit" onclick="info()"><a > Continuar</a></button>
                	</div>
                
            </form>
        </div>
    </div>
</body>

<script>
	function info() {
		window.alert("Olhe no seu terminal!");
	}
</script>

</html>

