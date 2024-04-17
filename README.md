1.Clase EditorDeTexto:

Esta clase es la ventana principal del editor de texto
Hereda de JFrame para crear la pestaña
Contiene botones, desplegables y el área de texto

2.Componentes de la Interfaz de Usuario:

JTextPane: Es un área de texto enriquecido que permite formatear el texto
Botones (JButton): Permiten realizar acciones como negrita, cursiva, etc...
Menús desplegables (JComboBox) para tipografía y tamaño de fuente: Permiten al usuario seleccionar la tipografía y el tamaño de la fuente

3.Funcionalidades:

Negrita, Cursiva y Cambio de Color: Estos botones permiten cambiar el formato del texto y el color
Selección de Tipografía y Tamaño de Fuente: Los  desplegables permiten elegir la tipografía y el tamaño de la fuente
Listeners: Cada botón y desplegable tiene asociado un "Listener" que responde a los clics o selecciones

4.Funciones Internas:

BoldButtonListener, ItalicButtonListener, ColorButtonListener, FontFamilyListener, FontSizeListener: Estos son los "Listener" que implementan las acciones de los botones y los desplegables
Cada uno de estos Listener modifica los atributos del texto en el JTextPane

5.Inicio de la Aplicación:

El método main crea una instancia del editor de texto y muestra una ventana para ingresar una contraseña para poder ejecutar el programa
Si la contraseña es correcta se realizan ajustes adicionales en la ventana del editor y si es incorrecta se muestra un mensaje de error y se cierra
