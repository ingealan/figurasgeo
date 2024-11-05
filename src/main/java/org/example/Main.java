package org.example;
//Nombre:Alan Solano
//Fecha:05/11/2024
//Detalle:Programa para calcular area, perimetro e hipotenusa de distintas formas geometricas
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            seleccionarFigura(opcion);

            System.out.print("\n¿Desea ingresar otra figura? (1 para sí, 0 para no): ");
            opcion = sc.nextInt();
        } while (opcion != 0);

        System.out.println("Programa finalizado.");
    }

    // Metodo para mostrar el menu
    private static void mostrarMenu() {
        System.out.println("\nSeleccione la figura geometrica:");
        System.out.println("1. Circulo");
        System.out.println("2. Rectangulo");
        System.out.println("3. Cuadrado");
        System.out.println("4. Triangulo");
        System.out.println("0. Salir");
        System.out.print("Ingrese su opcion: ");
    }

    // Metodo para seleccionar y manejar la figura geometrica
    private static void seleccionarFigura(int opcion) {
        switch (opcion) {
            case 1:
                manejarCirculo();
                break;
            case 2:
                manejarRectangulo();
                break;
            case 3:
                manejarCuadrado();
                break;
            case 4:
                manejarTriangulo();
                break;
            case 0:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opcion no valida.");
        }
    }

    // Clase interna para el Circulo
    static class Circulo {
        private double radio;

        public double getRadio() {
            return radio;
        }

        public void setRadio(double radio) {
            this.radio = radio;
        }

        public double calcularArea() {
            return Math.PI * radio * radio;
        }

        public double calcularPerimetro() {
            return 2 * Math.PI * radio;
        }
    }

    private static void manejarCirculo() {
        Circulo circulo = new Circulo();
        System.out.print("Ingrese el radio del circulo en cm: ");
        circulo.setRadio(sc.nextDouble());

        System.out.println("Area del circulo: " + circulo.calcularArea() + " cm²");
        System.out.println("Perimetro del circulo: " + circulo.calcularPerimetro() + " cm");
    }

    // Clase interna para el Rectangulo
    static class Rectangulo {
        private double base;
        private double altura;

        public double getBase() {
            return base;
        }

        public void setBase(double base) {
            this.base = base;
        }

        public double getAltura() {
            return altura;
        }

        public void setAltura(double altura) {
            this.altura = altura;
        }

        public double calcularArea() {
            return base * altura;
        }

        public double calcularPerimetro() {
            return 2 * (base + altura);
        }
    }

    private static void manejarRectangulo() {
        Rectangulo rectangulo = new Rectangulo();
        System.out.print("Ingrese la base del rectangulo en cm: ");
        rectangulo.setBase(sc.nextDouble());
        System.out.print("Ingrese la altura del rectangulo en cm: ");
        rectangulo.setAltura(sc.nextDouble());

        System.out.println("Area del rectangulo: " + rectangulo.calcularArea() + " cm²");
        System.out.println("Perimetro del rectangulo: " + rectangulo.calcularPerimetro() + " cm");
    }

    // Clase interna para el Cuadrado
    static class Cuadrado {
        private double lado;

        public double getLado() {
            return lado;
        }

        public void setLado(double lado) {
            this.lado = lado;
        }

        public double calcularArea() {
            return lado * lado;
        }

        public double calcularPerimetro() {
            return 4 * lado;
        }
    }

    private static void manejarCuadrado() {
        Cuadrado cuadrado = new Cuadrado();
        System.out.print("Ingrese la longitud de los lados del cuadrado en cm: ");
        cuadrado.setLado(sc.nextDouble());

        System.out.println("Area del cuadrado: " + cuadrado.calcularArea() + " cm²");
        System.out.println("Perimetro del cuadrado: " + cuadrado.calcularPerimetro() + " cm");
    }

    // Clase interna para el Triangulo
    static class Triangulo {
        private double lado1;
        private double lado2;
        private double lado3;

        public double getLado1() {
            return lado1;
        }

        public void setLado1(double lado1) {
            this.lado1 = lado1;
        }

        public double getLado2() {
            return lado2;
        }

        public void setLado2(double lado2) {
            this.lado2 = lado2;
        }

        public double getLado3() {
            return lado3;
        }

        public void setLado3(double lado3) {
            this.lado3 = lado3;
        }

        // Metodo para determinar el tipo de triangulo
        public String determinarTipoTriangulo() {
            if (lado1 == lado2 && lado2 == lado3) {
                return "Equilatero";
            } else if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3) {
                return "Isosceles";
            } else {
                return "Escaleno";
            }
        }

        // Metodo para calcular el perimetro
        public double calcularPerimetro() {
            return lado1 + lado2 + lado3;
        }

        // Metodo para calcular el area usando la formula de Heron
        public double calcularArea() {
            double s = (lado1 + lado2 + lado3) / 2;  // Semi-perimetro
            return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
        }

        // Metodo para calcular la hipotenusa (solo en caso de que sea un triangulo rectangulo)
        public double calcularHipotenusa() {
            if (lado1 * lado1 + lado2 * lado2 == lado3 * lado3) {
                return lado3;  // Hipotenusa, asumiendo que lado3 es la hipotenusa
            } else if (lado1 * lado1 + lado3 * lado3 == lado2 * lado2) {
                return lado2;  // Hipotenusa, asumiendo que lado2 es la hipotenusa
            } else if (lado2 * lado2 + lado3 * lado3 == lado1 * lado1) {
                return lado1;  // Hipotenusa, asumiendo que lado1 es la hipotenusa
            } else {
                return 0;  // No es un triangulo rectangulo
            }
        }
    }

    // Metodo para manejar los calculos del triangulo
    private static void manejarTriangulo() {
        Triangulo triangulo = new Triangulo();
        System.out.print("Ingrese el primer lado del triangulo en cm: ");
        triangulo.setLado1(sc.nextDouble());
        System.out.print("Ingrese el segundo lado del triangulo en cm: ");
        triangulo.setLado2(sc.nextDouble());
        System.out.print("Ingrese el tercer lado del triangulo en cm: ");
        triangulo.setLado3(sc.nextDouble());

        // Determinar el tipo de triangulo
        System.out.println("Tipo de triangulo: " + triangulo.determinarTipoTriangulo());

        // Calcular y mostrar el perimetro y el area
        System.out.println("Perimetro del triangulo: " + triangulo.calcularPerimetro() + " cm");
        System.out.println("Area del triangulo: " + triangulo.calcularArea() + " cm²");

        // Calcular la hipotenusa (si es un triangulo rectangulo)
        double hipotenusa = triangulo.calcularHipotenusa();
        if (hipotenusa > 0) {
            System.out.println("Hipotenusa del triangulo: " + hipotenusa + " cm");
        } else {
            System.out.println("El triangulo no es rectangulo, no se puede calcular la hipotenusa.");
        }
    }
}
