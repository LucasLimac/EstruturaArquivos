# EstruturaArquivos

Repositório referente a matéria de Organização de Estrutura de Arquivos CEFET/RJ.

No código tem a classe Endereço onde irá setar todos os registros do cep_ordenado.dat e tem a Main que irá chamar a função de BuscaBinaria
passando como parametro o RandomAccessFile do cep_ordenado, o primeiro registro, o ultimo registro e o cep que você quer achar.

Na função ele fará várias divisões e comparações de forma recursiva até achar o registro em que o cep se encontra. Ao achar o registro retornará um Long do registro, e na main chamará a função leEndereco da Classe Endereco, que atuará como construtor e setará todos os dados na instancia da classe. Após isso, vai printar na tela os dados referente aquele registro onde o cep foi encontrado, usando os métodos getters da função Endereco.

O arquivo Cep Ordenado foi diminuido para 49322 linhas(registros), e os ceps disponíveis para a procura são de 88301040 até 99099000. Logo se tentar buscar outro cep que não esteja neste intervalo gerará um erro. 

Exemplos de Ceps para procurar: 93222490 , 88301210.
