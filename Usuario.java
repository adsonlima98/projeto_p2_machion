
public class Usuario {

    private int matricula;  
    private String nome;   
    private String email;   


    public Usuario(int matricula, String nome, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
    }


    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Usuario{matricula=" + matricula + ", nome='" + nome + "', email='" + email + "'}";
    }

   
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario outro = (Usuario) obj;
        return this.matricula == outro.matricula;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(matricula);
    }
}
