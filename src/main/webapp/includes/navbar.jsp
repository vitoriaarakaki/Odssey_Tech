<div class="menu-mobile">
    <div class="aside-fechar">
        <h1 class="brand">
            <a href="Index.jsp">Out<span>s</span>ide trip
            </a>
        </h1>
        <button class="fechar-menu">X</button>
    </div>

    <ul>
        <li><a href="sobreNos.jsp">Sobre Nos</a></li>
        <li><a href="#cdLegal">Cards</a></li>
        <li><a href="#hotel">Hotel</a></li>
        <li><a href="#passagem">Passagens</a></li>
        <li><a href="Carrinho.jsp">carrinho</a></li>
        <li><a onclick="window.location.href ='Index.jsp#loginmodel'" class="login"> Login</a></li>
    </ul>

</div>


<div class="overlay"></div>
<div class="container">

    <nav>
        <h1 class="brand">
            <a href="Index.jsp">Out<span>s</span>ide trip
            </a>
        </h1>
        <button class="aside-menu">=</button>
        <ul>
            <li><a href="./sobreNos.jsp">Sobre Nós</a></li>
            <% if(auth ==null) {%>
            	<li><a href="#cdLegal">Cards</a></li>
            <%}%>
            
            <li><a href="#hotel">Hotels</a></li>
            <li><a href="#passagem">Passagens</a></li>


            <% if(auth !=null) {%>
                <li><a href="Carrinho.jsp">Carrinho <span class="badge badge-danger"> ${ cart_list.size() } </span></a>
                </li>
                <li><a href="Pedidos.jsp">Pedidos </a>
                </li>
                <li><a href="logout"> Logout</a></li>
                <%} else {%>
                    <li><a onclick="window.location.href ='Index.jsp#loginmodel'" class="login"> Login</a></li>
                    <%}%>


        </ul>
        <div id="loginmodel" class="loginmodel" style="z-index: 200;">
            <div class="popup">
                <h2>Entrar</h2>
                <form action="login" method="post">
                    <div class="content">
                        <section>
                            <input class="form-v-001" id="usuario_input" name="usuario-login"
                                placeholder="Insira seu Usuario">
                            <input class="form-v-001" id="senha_input" name="senha-login" type="password"
                                placeholder="******">

                            <div class="bts-login">
                                <button type="submit" onclick="info()" class="neons">
                                    <a>Login</a>
                                </button>
                                <button class="neons">
                                    <a href="./Inscrever-se.jsp">Inscrever-se</a>
                                </button>
                            </div>
                        </section>
                    </div>
                </form>
                <a class="close" href="#">&times;</a>
            </div>

        </div>
    </nav>
</div>