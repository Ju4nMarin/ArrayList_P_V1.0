
public class MetodosPersonas {

    private String nombre;
    private int edad;
    private String dni;
    private char sexo;
    private float peso;
    private float altura;

    public MetodosPersonas() {

    }

    public MetodosPersonas(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public MetodosPersonas(String nombre, int edad, String dni, char sexo, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public char getSexo() {
        return sexo;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }

    public String getCalcularImc() {
        String bajoPeso = "BajoPeso";
        String pesoIdeal = "PesoIdeal";
        String sobrePeso = "SobrePeso";

        float calcularPeso = (float) (peso / (Math.pow(altura, 2)));
        if (calcularPeso >= 20 && calcularPeso <= 25) {
            return pesoIdeal;
        } else if (calcularPeso < 20) {
            return bajoPeso;
        } else {
            return sobrePeso;
        }

    }

    public String getMayorDeEdad() {
        String Comp = "No";
        if (edad >= 18) {
            Comp = "Si";
        }
        return Comp;
    }

    public void getComprobarSexo(char sexo) {
        if (sexo != 'H' && sexo != 'M') {
            this.sexo = 'H';
        } else {
            this.sexo = sexo;
        }
    }

    public String getGenerarDni() {
        int NumRandom = ((int) Math.floor(Math.random() * (1000)));
        int NumRandom2 = ((int) Math.floor(Math.random() * (1000)));
        int LetRandom = 0;
        int LetRandom2 = 0;
        char lDni = getLetra(LetRandom);
        char lDni2 = getLetra(LetRandom2);

        return dni = Integer.toString(NumRandom) + lDni + (NumRandom2) + lDni2;
    }

    public char getLetra(int LetRandom) {
        int Letra = ((int) Math.floor(Math.random() * (26)));
        char letras[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        return letras[Letra];
    }

}
