function limpa_formulario_cep() {
        //Limpa valores do formulário de cep.
        document.getElementById('txtLogradouro').value=("");
        document.getElementById('txtBairro').value=("");
        document.getElementById('txtCidade').value=("");
        document.getElementById('txtEstado').value=("");
}

function validaCep(conteudo) {
    if (!("erro" in conteudo)) {
        //Atualiza os campos com os valores.
        document.getElementById('txtLogradouro').value=(conteudo.logradouro);
        document.getElementById('txtBairro').value=(conteudo.bairro);
        document.getElementById('txtCidade').value=(conteudo.localidade);
        document.getElementById('txtEstado').value=(conteudo.uf);
    } //end if.
    else {
        //CEP não Encontrado.
        limpa_formulario_cep();
        alert("CEP nao encontrado.");
    }
}
    
function pesquisacep(valor) {

    //Nova variável "cep" somente com dígitos.
    var cep = valor.replace(/\D/g, '');

    //Verifica se campo cep possui valor informado.
    if (cep != "") {

        //Expressão regular para validar o CEP.
        var validacep = /^[0-9]{8}$/;

        //Valida o formato do CEP.
        if(validacep.test(cep)) {

            //Preenche os campos com "..." enquanto consulta webservice.
            document.getElementById('txtLogradouro').value="...";
            document.getElementById('txtBairro').value="...";
            document.getElementById('txtCidade').value="...";
            document.getElementById('txtEstado').value="...";

            //Cria um elemento javascript.
            var script = document.createElement('script');

            //Sincroniza com o callback.
            script.src = '//viacep.com.br/ws/'+ cep + '/json/?callback=validaCep';

            //Insere script no documento e carrega o conteúdo.
            document.body.appendChild(script);

        } //end if.
        else {
            //cep é inválido.
            limpa_formulario_cep();
            alert("Formato de CEP invalido.");
        }
    } //end if.
    else {
        //cep sem valor, limpa formulário.
        limpa_formulario_cep();
    }
};