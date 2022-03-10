package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluno implements Comparable<Aluno> {
    private Integer id;
    private String name;
    private Date matricula;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Aluno() {
        
    }

    public Aluno(Integer id, String name, Date matricula) {
        this.id = id;
        this.name = name;
        this.matricula = matricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getMatricula() {
        return matricula;
    }

    public void setMatricula(Date matricula) {
        this.matricula = matricula;
    }

    @Override
    public int compareTo(Aluno outro) {
        return this.getName().toUpperCase().compareTo(outro.getName().toUpperCase());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(this.getName() + "," + this.getId() + "," + sdf.format(this.getMatricula()));
        
        return sb.toString();
    }
    
    
    
    
}
