function verificarCadastro(){  
    var passworLogin = document.getElementById("passwordCadastro");
    var r = new RegExp("(?=.*[0-9])(?=.*[A-Z]|(?=.*[a-z])).{9,}$");
    
    if(!r.test(passworLogin.value)){
        passworLogin.setCustomValidity("Não está no formato válido");
        return false;
    }else{
        passworLogin.setCustomValidity('');
        return true;
    }
}


function adicionarPessoas(){

    if(!verificarCadastro()){
        alert("Preencha os campos corretamente.");
        return;
    }

    var pessoa = {"primeiroNome":document.getElementById("primeiroNome").value, 
            "segundoNome":document.getElementById("segundoNome").value,
            "emailCadastro":document.getElementById("emailCadastro").value,
            "telefoneCadastro":document.getElementById("telefoneCadastro").value,
            "enderecoCadastro":document.getElementById("enderecoCadastro").value,
            "complementoCadastro":document.getElementById("complementoCadastro").value,
            "cidadeCadastro":document.getElementById("cidadeCadastro").value,
            "estadoCadastro":document.getElementById("estadoCadastro").value,
            "cepCadastro":document.getElementById("cepCadastro").value};
    var obj = JSON.stringify(pessoa);

    console.log(typeof pessoa);

    var aux = localStorage.length;
	localStorage.setItem("pessoa" + aux, obj);
	alert("Registro adicionado.");
    
    listarPessoas();
    
}

function listarPessoas(){
    var ht = document.getElementById('addCards');
    
    for(i=0;i<localStorage.length;i++){
        var vari = localStorage.getItem("pessoa"+i);
        console.log(typeof vari);
        console.log(vari);
        var p = JSON.parse(vari);
        
        ht.innerHTML += "<div class='card'><img class='card-img-top'src='img/pets/dog_example_2.jpg'alt='Imagem de capa do card'><div class='card-body'><h5 class='card-title'>Título do card</h5><p class='card-text'>" + 
        "<p class='card-text'>" +"Nome: "+ p.primeiroNome + " "+ p.segundoNome+ "</p>"+ 
        "<p class='card-text'>" +"Email: "+ p.emailCadastro + "</p>"+
        "<p class='card-text'>" +"Telefone: "+ p.telefoneCadastro + "</p>"+
        "<p class='card-text'>" +"Endereço: "+ p.enderecoCadastro + "</p>"+
        "<p class='card-text'>" +"Complemento: "+ p.complementoCadastro + "</p>"+
        "<p class='card-text'>" +"Cidade: "+ p.cidadeCadastro + "</p>"+
        "<p class='card-text'>" +"Estado: "+ p.estadoCadastro + "</p>"+
        "<p class='card-text'>" +"CEP: "+ p.cepCadastro + "</p>"+
        "</p></div><div class='card-footer'><small class='text-muted'>Atualizados 3 minutos atrás</small></div></div>";
    }
    
}

function adicionarPets(){
    var pessoa = {"nomePet":document.getElementById("nomePet").value, 
            "racaPet":document.getElementById("racaPet").value,
            "numberPet":document.getElementById("numberPet").value,
            "caracteristicasPet":document.getElementById("caracteristicasPet").value};
    var obj = JSON.stringify(pessoa);

    console.log(typeof pessoa);

    var aux = localStorage.length;
    localStorage.setItem("pet" + aux, obj);
    alert("Registro adicionado.");
    
    listarPets();
}

function listarPets(){
    var ht = document.getElementById('addCardsPets');
    
    for(i=0;i<localStorage.length;i++){
        var vari = localStorage.getItem("pet"+i);
        console.log(typeof vari);
        console.log(vari);
        var p = JSON.parse(vari);
        
        ht.innerHTML += "<div class='card'><img class='card-img-top'src='img/pets/dog_example_2.jpg'alt='Imagem de capa do card'><div class='card-body'><h5 class='card-title'>Título do card</h5><p class='card-text'>" + 
        "<p class='card-text'>" +"Nome: "+ p.nome + " "+ p.segundoNome+ "</p>"+ 
        "<p class='card-text'>" +"Raça: "+ p.racaPet + "</p>"+
        "<p class='card-text'>" +"Idade: "+ p.numberPet + "</p>"+
        "<p class='card-text'>" +"Características: "+ p.caracteristicasPet + "</p>"+
        "</p></div><div class='card-footer'><small class='text-muted'>Atualizados 3 minutos atrás</small></div></div>";
    }
}