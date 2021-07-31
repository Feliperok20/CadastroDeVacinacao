# CadastroDeVacinacao

## Uma API REST  voltada ao controle de aplicação de vacinas entre a população brasileira.


Construi um cadastro de usuários, sendo obrigatórios dados como: nome, e-mail, CPF e data de nascimento, onde e-mail e CPF devem ser únicos.

Também foi criado um cadastro de aplicação de vacinas, sendo obrigatórios dados como: nome da vacina, e-mail do usuário e a data que foi realizada a vacina.

Há apenas dois endpoints neste sistema, o cadastro do usuário e o cadastro da aplicação da vacina. 

Caso os cadastros estejam corretos, retornará o Status 201, caso hajam erros de preenchimento de dados, o Status retornado será o 400.

