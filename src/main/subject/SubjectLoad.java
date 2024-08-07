package main.subject;

/**
 * The SubjectLoad class is responsible for loading predefined subject data
 * for multiple careers. This class provides methods to initialize the data for each career
 * and populate the subjects records.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>data() - Loads the academic history data for all careers.</li>
 *   <li>dataCareer1() - Loads the subjects data for career 1.</li>
 *   <li>dataCareer2() - Loads the subjects data for career 2.</li>
 *   <li>dataCareer3() - Loads the subjects data for career 3.</li>
 *   <li>dataCareer4() - Loads the subjects data for career 4.</li>
 *   <li>dataCareer5() - Loads the subjects data for career 5.</li>
 * </ul>
 *
 * @version 1.0.0
 * @since 2024.04.05
 * @author Giuliano Ignacio Poeta
 */
public class SubjectLoad extends Subject {
    /**
     * Loads the subjects data for all careers.
     */
    public static void data() {
        dataCareer1();
        dataCareer2();
        dataCareer3();
        dataCareer4();
        dataCareer5();
    }

    /**
     * Loads the subjects data for career 1.
     */
    private static void dataCareer1() {
        new Subject("Física I para Ciencias Naturales", false, true, 1, 1);
        new Subject("Introducción a la Problemática Ambiental", false, true, 1, 1);
        new Subject("Introducción a las Ciencias Ambientales", false, true, 1, 1);
        new Subject("Introducción al Estudio de la Sociedad, la Cultura y el Ambiente", false, true, 1, 1);
        new Subject("Matemática I para Ciencias Naturales", false, true, 2, 1);
        new Subject("Matemática II para Ciencias Naturales", false, true, 2, 1);
        new Subject("Química General e Inorgánica", false, true, 2, 1);
        new Subject("Química Orgánica", false, true, 2, 1);
        new Subject("Diversidad Biológica", false, true, 3, 1);
        new Subject("Economía y Ambiente", false, true, 3, 1);
        new Subject("Estadística I para Ciencias Naturales", false, true, 3, 1);
        new Subject("Geografía Física para Ciencias Ambientales", false, true, 3, 1);
        new Subject("Introducción a la Biología", false, true, 4, 1);
        new Subject("Introducción a la Geología", false, true, 4, 1);
        new Subject("Legislación Ambiental", false, true, 4, 1);
        new Subject("Sociedad y Ambiente", false, true, 4, 1);
        new Subject("Comunicación Ambiental", false, true, 5, 1);
        new Subject("Ecología General", false, true, 5, 1);
        new Subject("Energías Renovables", false, true, 5, 1);
        new Subject("Filosofía, Epistemología y Metodología de la Ciencia", false, true, 5, 1);
        new Subject("Hidrología y Gestión del Agua", false, true, 6, 1);
        new Subject("Química Ambiental y Contaminación", false, true, 6, 1);
        new Subject("Técnicas de Tratamiento y Saneamiento", false, true, 6, 1);
        new Subject("Teledetección y SIG", false, true, 6, 1);
        new Subject("Administración Ambiental", false, true, 7, 1);
        new Subject("Cambio Global", false, true, 7, 1);
        new Subject("Conservación de la Biodiversidad", false, true, 7, 1);
        new Subject("Gestión de Ambientes Rurales", false, true, 7, 1);
        new Subject("Gestión de Ambientes Urbanos", false, true, 8, 1);
        new Subject("Gestión Integral de Recursos Naturales", false, true, 8, 1);
        new Subject("Seminario de Problemática Fueguina", false, true, 8, 1);
        new Subject("Taller de Metodología de la Investigación", false, true, 8, 1);
        new Subject("Desarrollo Económico Sostenible", false, true, 9, 1);
        new Subject("Áreas Protegidas", true, true, 9, 1);
        new Subject("Biología Vegetal", true, true, 9, 1);
        new Subject("Diversidad Animal I", true, true, 9, 1);
        new Subject("Diversidad Animal II", true, true, 9, 1);
        new Subject("Estadística Avanzada para Ciencias Naturales", true, true, 9, 1);
        new Subject("Física II para Ciencias Naturales", true, true, 9, 1);
        new Subject("Genética y Evolución", true, true, 9, 1);
        new Subject("Geografía y Dimensión Espacial del Desarrollo", true, true, 9, 1);
        new Subject("Manejo de Bosques", true, true, 9, 1);
        new Subject("Microorganismos de Ecosistemas Terrestres Patagónicos", true, true, 9, 1);
        new Subject("Paisajes Fueguinos", true, true, 9, 1);
        new Subject("Química Biológica", true, true, 9, 1);
        new Subject("Riesgos Ambientales", true, true, 9, 1);
        new Subject("Riesgos Ambientales Patagónicos", true, true, 9, 1);
        new Subject("Turismo y Ambiente", true, true, 9, 1);
        new Subject("Ordenamiento Ambiental del Territorio", false, true, 10, 1);
        new Subject("Taller de Evaluación de Impacto Ambiental", false, true, 10, 1);
        new Subject("Taller de Trabajo Final", false, true, 10, 1);
    }

    /**
     * Loads the subjects data for career 2.
     */
    private static void dataCareer2() {
        new Subject("Física I para Ciencias Naturales", false, true, 1, 2);
        new Subject("Introducción a la Geología", false, true, 1, 2);
        new Subject("Introducción a las Ciencias del Océano y Atmósfera", false, true, 1, 2);
        new Subject("Matemática Avanzada para Geología", false, true, 2, 2);
        new Subject("Matemática I para Ciencias Naturales", false, true, 2, 2);
        new Subject("Química General e Inorgánica", false, true, 2, 2);
        new Subject("Carteo Geológico", false, true, 3, 2);
        new Subject("Elementos de Estadística para Geología", false, true, 3, 2);
        new Subject("Física II para Ciencias Naturales", false, true, 3, 2);
        new Subject("Geoquímica", false, true, 3, 2);
        new Subject("Mineralogía I", false, true, 4, 2);
        new Subject("Mineralogía II", false, true, 4, 2);
        new Subject("Paleontología", false, true, 4, 2);
        new Subject("Filosofía, Epistemología y Metodología de las Ciencias Naturales", false, true, 5, 2);
        new Subject("Geofísica", false, true, 5, 2);
        new Subject("Geología Estructural", false, true, 5, 2);
        new Subject("Geomorfología", false, true, 6, 2);
        new Subject("Petrología de Rocas Ígneas", false, true, 6, 2);
        new Subject("Petrología de Rocas Metamórficas", false, true, 6, 2);
        new Subject("Sedimentología", false, true, 6, 2);
        new Subject("Estratigrafía", false, true, 7, 2);
        new Subject("Geología de Yacimientos", false, true, 7, 2);
        new Subject("Geología Histórica", false, true, 7, 2);
        new Subject("Hidrogeología", false, true, 7, 2);
        new Subject("Introducción al Estudio de la Sociedad, la Cultura y el Ambiente", false, true, 8, 2);
        new Subject("Pedología", false, true, 8, 2);
        new Subject("Teledetección y SIG", false, true, 8, 2);
        new Subject("Energías Renovables", false, true, 9, 2);
        new Subject("Geología de Combustibles", false, true, 9, 2);
        new Subject("Geología Económica", false, true, 9, 2);
        new Subject("Geología Legal", false, true, 9, 2);
        new Subject("Geología Regional Argentina", false, true, 10, 2);
        new Subject("Geotecnia", false, true, 10, 2);
        new Subject("Cambio Global", true, true, 10, 2);
        new Subject("Geología Marina", true, true, 10, 2);
        new Subject("Legislación Ambiental", true, true, 10, 2);
        new Subject("Paisajes Fueguinos", true, true, 10, 2);
        new Subject("Química Ambiental y Contaminación", true, true, 10, 2);
        new Subject("Seminario de Problemática Fueguina", true, true, 10, 2);
        new Subject("Yacimientos no Metalíferos", true, true, 10, 2);
        new Subject("Yacimientos Pegmatíticos", true, true, 10, 2);
        new Subject("Cambio Global", true, true, 10, 2);
        new Subject("Comunicación Pública de las Ciencias", true, true, 10, 2);
        new Subject("Génesis y Dinámica de Paisajes Fueguinos", true, true, 10, 2);
        new Subject("Química Ambiental y Contaminación", true, true, 10, 2);
        new Subject("Sistemas Turbidíticos de Tierra del Fuego", true, true, 10, 2);
        new Subject("Taller de Evaluación de Impacto Ambiental", true, true, 10, 2);
        new Subject("Taller de Metodología de la Investigación", true, true, 10, 2);
        new Subject("Sistemas Turbidíticos de Tierra del Fuego", true, true, 10, 2);
        new Subject("Taller de Metodología de la Investigación", true, true, 10, 2);
        new Subject("Yacimientos Pegmatíticos", true, true, 10, 2);
        new Subject("Riesgo Geológico y Geología Ambiental", false, true, 10, 2);
    }

    /**
     * Loads the subjects data for career 3.
     */
    private static void dataCareer3() {
        new Subject("Introducción a la Ingeniería", false, true, 1, 3);
        new Subject("Introducción al Cálculo", false, true, 1, 3);
        new Subject("Introducción al Estudio de la Sociedad, la Cultura y el Ambiente", false, true, 1, 3);
        new Subject("Química", false, true, 1, 3);
        new Subject("Sistemas de Representación", false, true, 1, 3);
        new Subject("Álgebra", false, true, 2, 3);
        new Subject("Física I", false, true, 2, 3);
        new Subject("Matemática I", false, true, 2, 3);
        new Subject("Pensamiento Sistémico", false, true, 2, 3);
        new Subject("Introducción a la Economía", false, true, 3, 3);
        new Subject("Matemática II", false, true, 3, 3);
        new Subject("Mecánica Elemental", false, true, 3, 3);
        new Subject("Programación y Métodos Numéricos", false, true, 3, 3);
        new Subject("Estadística", false, true, 4, 3);
        new Subject("Estática y Resistencia de los Materiales", false, true, 4, 3);
        new Subject("Examen Nivel I de Inglés", false, true, 4, 3);
        new Subject("Física II", false, true, 4, 3);
        new Subject("Matemática III Para Ingenieros", false, true, 4, 3);
        new Subject("Ciencia de los Materiales", false, true, 5, 3);
        new Subject("Electrotecnia", false, true, 5, 3);
        new Subject("Mecánica de los Fluidos", false, true, 5, 3);
        new Subject("Organización de la Producción I", false, true, 5, 3);
        new Subject("Seminario de Entrevistas Profesionales", false, true, 5, 3);
        new Subject("Termodinámica", false, true, 5, 3);
        new Subject("Mecanismos y Elementos de Máquinas", false, true, 6, 3);
        new Subject("Organización de la Producción II", false, true, 6, 3);
        new Subject("Procesos de Fabricación", false, true, 6, 3);
        new Subject("Seminario de Problemática Fueguina", false, true, 6, 3);
        new Subject("Termotécnia y Máquinaria Térmica", false, true, 6, 3);
        new Subject("Calidad", false, true, 7, 3);
        new Subject("Costos Industriales", false, true, 7, 3);
        new Subject("Investigación Operativa", false, true, 7, 3);
        new Subject("Marketing e Inteligencia Comercial", false, true, 7, 3);
        new Subject("Sistemas de Control Industrial", false, true, 7, 3);
        new Subject("Desarrollo de Productos", false, true, 8, 3);
        new Subject("Examen Nivel II de Inglés", false, true, 8, 3);
        new Subject("Instalaciones Industriales", false, true, 8, 3);
        new Subject("Inversión y Proyectos", false, true, 8, 3);
        new Subject("Mantenimiento", false, true, 8, 3);
        new Subject("Examen Nivel I de Portugués", false, true, 9, 3);
        new Subject("Legislación", false, true, 9, 3);
        new Subject("Coaching y Liderazgo", true, true, 9, 3);
        new Subject("Desarrollo de Productos II", true, true, 9, 3);
        new Subject("Desarrollo Territorial", true, true, 9, 3);
        new Subject("Economía de la Energía", true, true, 9, 3);
        new Subject("Economía de los Recursos Naturales y Ambiente", true, true, 9, 3);
        new Subject("Economías Latinoamericanas y Emergentes", true, true, 9, 3);
        new Subject("Ergonomía", true, true, 9, 3);
        new Subject("Introducción a la Ecoenergía", true, true, 9, 3);
        new Subject("Política Macroeconómica Avanzada", true, true, 9, 3);
        new Subject("Recursos Humanos", false, true, 9, 3);
        new Subject("Seguridad e Higiene y Gestión Ambiental", false, true, 9, 3);
        new Subject("Taller de Creación de Empresas", false, true, 9, 3);
        new Subject("Trabajo Final 1", false, true, 9, 3);
        new Subject("Dirección Industrial y Gerenciamiento", false, true, 10, 3);
        new Subject("Distribución y Logística", false, true, 10, 3);
        new Subject("Examen Nivel III de Inglés", false, true, 10, 3);
        new Subject("Práctica Profesional Supervisada", false, true, 10, 3);
        new Subject("Seminario de Pensamiento Sistémico", false, true, 10, 3);
        new Subject("Seminario Lean Manufacturing y Teoría de las Restricciones", false, true, 10, 3);
        new Subject("Trabajo Final 2", false, true, 10, 3);
    }

    /**
     * Loads the subjects data for career 4.
     */
    private static void dataCareer4() {
        new Subject("Álgebra", false, true, 1, 4);
        new Subject("Elementos de Informática", false, true, 1, 4);
        new Subject("Expresión de Problemas y Algoritmos", false, true, 1, 4);
        new Subject("Algorítmica y Programación I", false, true, 2, 4);
        new Subject("Análisis Matemático", false, true, 2, 4);
        new Subject("Elementos de Lógica y Matemática Discreta", false, true, 2, 4);
        new Subject("Algorítmica y Programación II", false, true, 3, 4);
        new Subject("Arquitectura de Computadoras", false, true, 3, 4);
        new Subject("Estadística", false, true, 3, 4);
        new Subject("Sistemas y Organizaciones", false, true, 3, 4);
        new Subject("Bases de Datos I", false, true, 4, 4);
        new Subject("Ingeniería de Software I", false, true, 4, 4);
        new Subject("Programación y Diseño Orientado a Objetos", false, true, 4, 4);
        new Subject("Fundamentos Teóricos de Informática", false, true, 5, 4);
        new Subject("Ingeniería de Software II", false, true, 5, 4);
        new Subject("Introducción a la Concurrencia", false, true, 5, 4);
        new Subject("Laboratorio de Programación y Lenguajes", false, true, 5, 4);
        new Subject("Bases de Datos II", false, true, 6, 4);
        new Subject("Laboratorio de Software", false, true, 6, 4);
        new Subject("Seminario de Aspectos Legales y Profesionales I", false, true, 6, 4);
        new Subject("Sistemas Operativos", false, true, 6, 4);
        new Subject("Paradigmas y Lenguajes de Programación", false, true, 7, 4);
        new Subject("Redes y Transmisión de Datos", false, true, 7, 4);
        new Subject("Taller de Nuevas Tecnologías", false, true, 7, 4);
        new Subject("Ingeniería de Software III", false, true, 8, 4);
        new Subject("Seminario de Aspectos Legales y Profesionales II", false, true, 8, 4);
        new Subject("Sistemas Distribuidos", false, true, 8, 4);
        new Subject("Sistemas Inteligentes", false, true, 8, 4);
        new Subject("Bases de Datos Distribuidas", false, true, 9, 4);
        new Subject("Seminario de Seguridad", false, true, 9, 4);
        new Subject("Sistemas de Tiempo Real", false, true, 9, 4);
        new Subject("Sistemas Paralelos", false, true, 9, 4);
        new Subject("Modelos y Simulación", false, true, 10, 4);
        new Subject("Proyecto de Software", false, true, 10, 4);
    }

    /**
     * Loads the subjects data for career 5.
     */
    private static void dataCareer5() {
        new Subject("Contabilidad", false, true, 1, 5);
        new Subject("Introducción a la Economía", false, true, 1, 5);
        new Subject("Introducción al Cálculo", false, true, 1, 5);
        new Subject("Introducción al Estudio de la Sociedad, la Cultura y el Ambiente", false, true, 1, 5);
        new Subject("Epistemología de las Ciencias Sociales", false, true, 2, 5);
        new Subject("Fundamentos de Sociología", false, true, 2, 5);
        new Subject("Matemática I", false, true, 2, 5);
        new Subject("Microeconomía I", false, true, 2, 5);
        new Subject("Administración y Gestión Empresarial", false, true, 3, 5);
        new Subject("Álgebra", false, true, 3, 5);
        new Subject("Macroeconomía I", false, true, 3, 5);
        new Subject("Taller de Fuentes de Información Económico y Social", false, true, 3, 5);
        new Subject("Examen Nivel I de Inglés", false, true, 4, 5);
        new Subject("Fundamentos de Ciencia Política", false, true, 4, 5);
        new Subject("Historia del Pensamiento Económico I", false, true, 4, 5);
        new Subject("Macroeconomía II", false, true, 4, 5);
        new Subject("Matemática II", false, true, 4, 5);
        new Subject("Economía Organizacional", false, true, 5, 5);
        new Subject("Estadística", false, true, 5, 5);
        new Subject("Historia del Pensamiento Económico II", false, true, 5, 5);
        new Subject("Instituciones, Derecho, Economía y Negocios", false, true, 5, 5);
        new Subject("Historia Social Argentina", false, true, 6, 5);
        new Subject("Matemática para Economistas", false, true, 6, 5);
        new Subject("Taller de Investigación de Metodología Cuantitativa y Cualitativa", false, true, 6, 5);
        new Subject("Tópicos de Crecimiento Económico y Desarrollo", false, true, 6, 5);
        new Subject("Comercio Internacional Economía Global y Globalización", false, true, 7, 5);
        new Subject("Dinero, Agregados Monetarios y Sistema Financiero", false, true, 7, 5);
        new Subject("Econometría", false, true, 7, 5);
        new Subject("Examen Nivel II de Inglés", false, true, 8, 5);
        new Subject("Contabilidad II", true, true, 8, 5);
        new Subject("Creación de Empresas", true, true, 8, 5);
        new Subject("Dirección y Gerenciamiento", true, true, 8, 5);
        new Subject("Economías y Ruralidades en Patagonia Sur", true, true, 8, 5);
        new Subject("Historia Social Latinoamericana", true, true, 8, 5);
        new Subject("Taller de Comercio Exterior", true, true, 8, 5);
        new Subject("Taller de Economía Latinoamericana y Emergentes", true, true, 8, 5);
        new Subject("Taller de Gestión Emprendedora II", true, true, 8, 5);
        new Subject("Taller de Gestión Emprendedora III", true, true, 8, 5);
        new Subject("Análisis Economíco de Coyuntura", true, true, 8, 5);
        new Subject("Econometría Avanzada", true, true, 8, 5);
        new Subject("Economía de la Energía", true, true, 8, 5);
        new Subject("Economía de los Recursos Naturales y Ambiente", true, true, 8, 5);
        new Subject("Economía del Turismo", true, true, 8, 5);
        new Subject("Economías Latinoamericanas y Emergentes", true, true, 8, 5);
        new Subject("Evaluación de Proyectos de Inversión", true, true, 8, 5);
        new Subject("Historia del Desarrollo Económico Argentino", true, true, 8, 5);
        new Subject("La Imposibilidad de sí. Forma de violencia y subjetivación en las sociedades contemporáneas", true,
                true, 8, 5);
        new Subject("La política internacional latinoamericana contemporánea", true, true, 8, 5);
        new Subject("Microeconomía Avanzada", true, true, 8, 5);
        new Subject("Política Macroeconómica Avanzada", true, true, 8, 5);
        new Subject("Políticas Públicas y Proyectos de Intervención Social", true, true, 8, 5);
        new Subject("Sistema Financiero Internacional y Flujos de Capital", true, true, 8, 5);
        new Subject("Sociología Política", true, true, 8, 5);
        new Subject("Taller de Creación de Empresas", true, true, 8, 5);
        new Subject("Taller de Gestión Emprendedora I", true, true, 8, 5);
        new Subject("Teoría de los Juegos", true, true, 8, 5);
        new Subject("Teoría Social Foucaultiana", true, true, 8, 5);
        new Subject("Teorías de la Innovación, del Progreso Técnico y de los Sistemas Evolutivos", true, true, 8, 5);
        new Subject("Tópicos de Matemática para su Aplicación en Ingeniería y Economía", true, true, 8, 5);
        new Subject("Pensamiento Económico y Social Latinoamericano", false, true, 8, 5);
        new Subject("Política Económica y Finanzas Públicas", false, true, 8, 5);
        new Subject("Práctica profesional I", false, true, 8, 5);
        new Subject("Examen Nivel I de Portugués", false, true, 9, 5);
        new Subject("Seminario de Problemática Fueguina", false, true, 9, 5);
        new Subject("Taller Trabajo Final", false, true, 9, 5);
        new Subject("Examen Nivel III de Inglés", false, true, 10, 5);
        new Subject("Práctica profesional II", false, true, 10, 5);
        new Subject("Trabajo Final", false, true, 10, 5);
    }
}
