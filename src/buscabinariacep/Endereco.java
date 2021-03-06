    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package buscabinariacep;
    import java.io.DataInput;
    import java.io.IOException;
    import java.nio.charset.Charset;
    
    /**
    *
    * @author Lucas Lima
    */

    public class Endereco {

        private String logradouro;
        private String bairro;
        private String cidade;
        private String estado;
        private String sigla;
        private String cep;
        
        /**
         * receberá o registro e atuará como construtor setando os valores na classe.
         * @param din é o registro 
         * @throws IOException 
         */

        public void leEndereco(DataInput din) throws IOException
        {
            byte logradouro[] = new byte[72];
            byte bairro[] = new byte[72];
            byte cidade[] = new byte[72];
            byte estado[] = new byte[72];
            byte sigla[] = new byte[2];
            byte cep[] = new byte[8];


            din.readFully(logradouro);
            din.readFully(bairro);
            din.readFully(cidade);
            din.readFully(estado);
            din.readFully(sigla);
            din.readFully(cep);
            din.readByte(); // Ultimo espaco em branco 
            din.readByte(); // Quebra de linha

            // Definie a forma como caracteres especias estão codificados.
            Charset enc = Charset.forName("ISO-8859-1");

            this.logradouro = new String(logradouro,enc);
            this.bairro = new String(bairro,enc);
            this.cidade = new String(cidade,enc);
            this.estado = new String(estado,enc);
            this.sigla = new String(sigla,enc);
            this.cep = new String(cep,enc);
        }

        public String getLogradouro() {
            return logradouro;
        }

        public void setLogradouro(String logradouro) {
            this.logradouro = logradouro;
        }

        public String getBairro() {
            return bairro;
        }

        public void setBairro(String bairro) {
            this.bairro = bairro;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getSigla() {
            return sigla;
        }

        public void setSigla(String sigla) {
            this.sigla = sigla;
        }

        public String getCep() {
            return cep;
        }

        public void setCep(String cep) {
            this.cep = cep;
        }

    }
