package tabelas;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.*;
import java.time.LocalDate;

    @Entity
    @Table(name = "Usuario")
    public class Usuario {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idUsuario;

        private String nome;
        private String cpf;
        private String telefone;

        private LocalDate dtNasc;

        private String email;
        private String cep;

        public int getIdUsuario() {
            return idUsuario;
        }

        public void setIdUsuario(int idUsuario) {
            this.idUsuario = idUsuario;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public LocalDate getDtNasc() {
            return dtNasc;
        }

        public void setDtNasc(LocalDate dtNasc) {
            this.dtNasc = dtNasc;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCep() {
            return cep;
        }

        public void setCep(String cep) {
            this.cep = cep;
        }
    }
