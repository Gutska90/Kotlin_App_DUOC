package com.example.mykotlinappduoc.data

import java.util.Date

/**
 * Repositorio de recetas de ejemplo para la aplicación
 * Incluye recetas para cada tipo de comida del día
 */
object SampleRecipes {
    
    val desayunos = listOf(
        Recipe(
            id = "desayuno_1",
            name = "Avena con Frutas",
            description = "Avena cocida con plátano, fresas y miel. Rico en fibra y vitaminas. Perfecto para empezar el día con energía.",
            ingredients = listOf(
                "1 taza de avena en hojuelas (80g)",
                "2 tazas de leche descremada (500ml)",
                "1 plátano maduro mediano",
                "5 fresas frescas grandes",
                "2 cucharadas de miel natural (30ml)",
                "1 cucharada de nueces picadas (15g)",
                "1 pizca de canela en polvo",
                "1 cucharadita de extracto de vainilla (5ml)"
            ),
            instructions = listOf(
                "En una olla mediana, calentar la leche a fuego medio hasta que esté tibia",
                "Agregar la avena y revolver constantemente para evitar grumos",
                "Cocinar a fuego medio-bajo por 5-7 minutos hasta que la avena esté cremosa",
                "Retirar del fuego y agregar la vainilla y canela, mezclar bien",
                "Mientras tanto, lavar y cortar las fresas en rodajas",
                "Pelar y cortar el plátano en rodajas de 1cm de grosor",
                "Servir la avena caliente en dos tazones",
                "Distribuir las frutas por encima de manera decorativa",
                "Rociar con miel y espolvorear las nueces picadas",
                "Servir inmediatamente mientras esté caliente"
            ),
            prepTime = 8,
            cookTime = 7,
            servings = 2,
            calories = 320,
            category = "Desayuno",
            difficulty = "Fácil",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        ),
        Recipe(
            id = "desayuno_2",
            name = "Tostadas con Aguacate",
            description = "Pan integral tostado con aguacate, tomate y huevo pochado. Una opción nutritiva y deliciosa para el desayuno.",
            ingredients = listOf(
                "2 rebanadas de pan integral grueso",
                "1 aguacate maduro mediano",
                "1 tomate grande y firme",
                "2 huevos frescos grandes",
                "1 cucharadita de sal marina (5g)",
                "1/2 cucharadita de pimienta negra molida (2g)",
                "2 cucharadas de aceite de oliva extra virgen (30ml)",
                "1 cucharadita de jugo de limón (5ml)",
                "1 pizca de hojuelas de chile rojo (opcional)",
                "1 cucharada de cilantro fresco picado (15g)"
            ),
            instructions = listOf(
                "Tostar las rebanadas de pan integral hasta que estén doradas y crujientes",
                "Cortar el aguacate por la mitad, retirar el hueso y extraer la pulpa",
                "Machacar el aguacate con un tenedor hasta obtener una consistencia cremosa",
                "Agregar sal, pimienta, jugo de limón y mezclar bien",
                "Lavar y cortar el tomate en rodajas de 1cm de grosor",
                "En una sartén antiadherente, calentar 1 cucharada de aceite de oliva",
                "Cascar los huevos en un plato pequeño para verificar que estén frescos",
                "Agregar 1 cucharada de vinagre blanco al agua hirviendo en una olla",
                "Crear un remolino en el agua y agregar los huevos uno por uno",
                "Cocinar los huevos pochados por 3-4 minutos hasta que la clara esté firme",
                "Retirar con una espumadera y escurrir sobre papel absorbente",
                "Untar generosamente el aguacate sobre las tostadas",
                "Colocar las rodajas de tomate sobre el aguacate",
                "Agregar los huevos pochados encima",
                "Rociar con aceite de oliva restante y espolvorear cilantro",
                "Servir inmediatamente con una pizca de hojuelas de chile si se desea"
            ),
            prepTime = 12,
            cookTime = 8,
            servings = 2,
            calories = 450,
            category = "Desayuno",
            difficulty = "Medio",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        ),
        Recipe(
            id = "desayuno_3",
            name = "Smoothie Verde",
            description = "Batido saludable con espinacas, plátano, mango y leche de almendras.",
            ingredients = listOf(
                "1 taza de espinacas frescas",
                "1 plátano congelado",
                "1/2 mango",
                "1 taza de leche de almendras",
                "1 cucharada de miel",
                "1 cucharada de semillas de chía"
            ),
            instructions = listOf(
                "Lavar las espinacas",
                "Pelar y cortar el mango",
                "Agregar todos los ingredientes a la licuadora",
                "Licuar por 2 minutos hasta obtener consistencia suave",
                "Servir inmediatamente"
            ),
            prepTime = 5,
            cookTime = 0,
            servings = 2,
            calories = 180,
            category = "Desayuno",
            difficulty = "Fácil",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        ),
        Recipe(
            id = "desayuno_4",
            name = "Pancakes de Avena",
            description = "Pancakes saludables hechos con avena, plátano y huevo.",
            ingredients = listOf(
                "1 taza de avena",
                "2 plátanos maduros",
                "2 huevos",
                "1 cucharadita de canela",
                "1 cucharadita de extracto de vainilla",
                "Aceite de coco para cocinar"
            ),
            instructions = listOf(
                "Licuar la avena hasta hacer harina",
                "Machacar los plátanos",
                "Mezclar todos los ingredientes",
                "Calentar aceite en sartén",
                "Cocinar pancakes por 3 minutos cada lado"
            ),
            prepTime = 10,
            cookTime = 15,
            servings = 3,
            calories = 280,
            category = "Desayuno",
            difficulty = "Fácil",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        ),
        Recipe(
            id = "desayuno_5",
            name = "Yogurt con Granola",
            description = "Yogurt griego con granola casera, frutos rojos y miel.",
            ingredients = listOf(
                "1 taza de yogurt griego",
                "1/2 taza de granola",
                "1/4 taza de frutos rojos",
                "2 cucharadas de miel",
                "1 cucharada de almendras fileteadas"
            ),
            instructions = listOf(
                "Servir yogurt en un bowl",
                "Agregar granola por encima",
                "Distribuir los frutos rojos",
                "Rociar con miel",
                "Espolvorear almendras"
            ),
            prepTime = 5,
            cookTime = 0,
            servings = 1,
            calories = 350,
            category = "Desayuno",
            difficulty = "Fácil",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        )
    )
    
    val almuerzos = listOf(
        Recipe(
            id = "almuerzo_1",
            name = "Ensalada César con Pollo",
            description = "Ensalada fresca con lechuga, pollo a la plancha, crutones y aderezo césar. Una comida completa y nutritiva.",
            ingredients = listOf(
                "2 pechugas de pollo sin piel (300g)",
                "1 lechuga romana grande",
                "1/2 taza de crutones caseros (60g)",
                "1/4 taza de queso parmesano rallado (30g)",
                "3 cucharadas de aceite de oliva extra virgen (45ml)",
                "2 dientes de ajo picados",
                "1 cucharadita de sal marina (5g)",
                "1/2 cucharadita de pimienta negra molida (2g)",
                "1 cucharadita de orégano seco (2g)",
                "2 cucharadas de jugo de limón (30ml)",
                "1 cucharadita de mostaza Dijon (5ml)",
                "1 cucharadita de anchoas en pasta (5g)",
                "1 yema de huevo pasteurizada"
            ),
            instructions = listOf(
                "Preparar el aderezo césar: mezclar yema de huevo, ajo, mostaza y anchoas",
                "Agregar gradualmente 2 cucharadas de aceite de oliva batiendo constantemente",
                "Incorporar jugo de limón, sal y pimienta al gusto",
                "Sazonar las pechugas de pollo con sal, pimienta y orégano",
                "Calentar una sartén con 1 cucharada de aceite de oliva a fuego medio-alto",
                "Cocinar el pollo por 6-7 minutos por cada lado hasta dorar",
                "Retirar del fuego y dejar reposar 5 minutos antes de cortar",
                "Lavar y secar completamente la lechuga romana",
                "Cortar la lechuga en trozos de bocado de 2-3cm",
                "Cortar el pollo en tiras de 1cm de grosor",
                "Tostar los crutones en una sartén seca por 2-3 minutos hasta dorar",
                "En un bowl grande, combinar la lechuga con la mitad del aderezo",
                "Agregar las tiras de pollo y mezclar suavemente",
                "Espolvorear con queso parmesano y crutones",
                "Servir inmediatamente con aderezo adicional al lado"
            ),
            prepTime = 20,
            cookTime = 15,
            servings = 2,
            calories = 420,
            category = "Almuerzo",
            difficulty = "Medio",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        ),
        Recipe(
            id = "almuerzo_2",
            name = "Salmón con Quinoa",
            description = "Salmón a la plancha con quinoa, espárragos y limón.",
            ingredients = listOf(
                "2 filetes de salmón",
                "1 taza de quinoa",
                "8 espárragos",
                "1 limón",
                "2 cucharadas de aceite de oliva",
                "Hierbas frescas"
            ),
            instructions = listOf(
                "Cocinar quinoa según instrucciones",
                "Cocinar espárragos al vapor",
                "Sazonar y cocinar salmón a la plancha",
                "Servir quinoa como base",
                "Colocar salmón y espárragos encima"
            ),
            prepTime = 10,
            cookTime = 25,
            servings = 2,
            calories = 480,
            category = "Almuerzo",
            difficulty = "Medio",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        ),
        Recipe(
            id = "almuerzo_3",
            name = "Bowl de Burrito",
            description = "Bowl saludable con arroz integral, frijoles, pollo y vegetales.",
            ingredients = listOf(
                "1 taza de arroz integral",
                "1/2 taza de frijoles negros",
                "1 pechuga de pollo",
                "1 aguacate",
                "1 tomate",
                "Lechuga, cilantro y limón"
            ),
            instructions = listOf(
                "Cocinar arroz integral",
                "Cocinar frijoles con especias",
                "Cocinar y desmenuzar pollo",
                "Cortar vegetales frescos",
                "Armar bowl con todos los ingredientes"
            ),
            prepTime = 20,
            cookTime = 30,
            servings = 2,
            calories = 520,
            category = "Almuerzo",
            difficulty = "Medio",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        ),
        Recipe(
            id = "almuerzo_4",
            name = "Pasta Integral con Vegetales",
            description = "Pasta integral con brócoli, tomates cherry y queso parmesano.",
            ingredients = listOf(
                "200g pasta integral",
                "1 brócoli",
                "1 taza de tomates cherry",
                "2 dientes de ajo",
                "1/4 taza de queso parmesano",
                "Aceite de oliva y hierbas"
            ),
            instructions = listOf(
                "Cocinar pasta según instrucciones",
                "Cocinar brócoli al vapor",
                "Saltear tomates con ajo",
                "Mezclar pasta con vegetales",
                "Servir con queso parmesano"
            ),
            prepTime = 10,
            cookTime = 20,
            servings = 2,
            calories = 380,
            category = "Almuerzo",
            difficulty = "Fácil",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        ),
        Recipe(
            id = "almuerzo_5",
            name = "Wrap de Pollo y Vegetales",
            description = "Wrap integral con pollo, vegetales frescos y hummus.",
            ingredients = listOf(
                "2 tortillas integrales",
                "1 pechuga de pollo",
                "1/2 pepino",
                "1 tomate",
                "Lechuga",
                "3 cucharadas de hummus"
            ),
            instructions = listOf(
                "Cocinar y cortar pollo en tiras",
                "Cortar vegetales en juliana",
                "Calentar tortillas ligeramente",
                "Untar hummus en tortillas",
                "Agregar pollo y vegetales, enrollar"
            ),
            prepTime = 15,
            cookTime = 15,
            servings = 2,
            calories = 350,
            category = "Almuerzo",
            difficulty = "Fácil",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        )
    )
    
    val cenas = listOf(
        Recipe(
            id = "cena_1",
            name = "Pescado al Horno con Vegetales",
            description = "Filete de pescado blanco al horno con zanahorias, calabacín y hierbas. Una cena ligera y saludable.",
            ingredients = listOf(
                "2 filetes de pescado blanco (merluza o bacalao) (400g)",
                "2 zanahorias medianas",
                "1 calabacín mediano",
                "1 cebolla morada pequeña",
                "3 cucharadas de aceite de oliva extra virgen (45ml)",
                "2 dientes de ajo picados",
                "1 cucharadita de sal marina (5g)",
                "1/2 cucharadita de pimienta negra molida (2g)",
                "1 cucharadita de tomillo fresco (2g)",
                "1 cucharadita de romero fresco (2g)",
                "1 limón orgánico",
                "1 cucharada de perejil fresco picado (15g)",
                "1 pizca de paprika dulce"
            ),
            instructions = listOf(
                "Precalentar el horno a 200°C (400°F)",
                "Lavar y pelar las zanahorias, cortar en bastones de 5cm",
                "Lavar el calabacín y cortar en rodajas de 1cm de grosor",
                "Pelar y cortar la cebolla en aros de 1cm de grosor",
                "En un bowl grande, mezclar todos los vegetales con 2 cucharadas de aceite de oliva",
                "Agregar ajo picado, sal, pimienta y hierbas frescas, mezclar bien",
                "Forrar una bandeja para horno con papel aluminio o papel pergamino",
                "Distribuir los vegetales en la bandeja formando una cama",
                "Sazonar los filetes de pescado con sal, pimienta y paprika",
                "Colocar los filetes sobre los vegetales",
                "Rociar con el aceite de oliva restante y jugo de medio limón",
                "Cortar el limón restante en rodajas y colocar sobre el pescado",
                "Hornear por 15-20 minutos hasta que el pescado esté opaco y se desmenuce fácilmente",
                "Verificar que los vegetales estén tiernos pinchándolos con un tenedor",
                "Retirar del horno y espolvorear con perejil fresco picado",
                "Servir inmediatamente con las rodajas de limón y vegetales como guarnición"
            ),
            prepTime = 20,
            cookTime = 20,
            servings = 2,
            calories = 320,
            category = "Cena",
            difficulty = "Fácil",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        ),
        Recipe(
            id = "cena_2",
            name = "Sopa de Lentejas",
            description = "Sopa nutritiva de lentejas con vegetales y especias.",
            ingredients = listOf(
                "1 taza de lentejas",
                "1 cebolla",
                "2 zanahorias",
                "2 tallos de apio",
                "2 dientes de ajo",
                "1 cucharadita de comino"
            ),
            instructions = listOf(
                "Remojar lentejas por 30 minutos",
                "Picar todos los vegetales",
                "Saltear cebolla y ajo",
                "Agregar lentejas y vegetales",
                "Cocinar por 30 minutos"
            ),
            prepTime = 20,
            cookTime = 35,
            servings = 4,
            calories = 280,
            category = "Cena",
            difficulty = "Fácil",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        ),
        Recipe(
            id = "cena_3",
            name = "Ensalada de Atún",
            description = "Ensalada fresca con atún, huevo, tomate y lechuga.",
            ingredients = listOf(
                "1 lata de atún en agua",
                "2 huevos duros",
                "1 tomate",
                "Lechuga mixta",
                "1/2 pepino",
                "Aceite de oliva y vinagre"
            ),
            instructions = listOf(
                "Cocinar huevos hasta que estén duros",
                "Lavar y cortar vegetales",
                "Escurrir atún",
                "Cortar huevos en rodajas",
                "Mezclar todos los ingredientes"
            ),
            prepTime = 10,
            cookTime = 10,
            servings = 2,
            calories = 250,
            category = "Cena",
            difficulty = "Fácil",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        ),
        Recipe(
            id = "cena_4",
            name = "Pollo a la Plancha con Ensalada",
            description = "Pechuga de pollo a la plancha con ensalada verde y aderezo ligero.",
            ingredients = listOf(
                "2 pechugas de pollo",
                "Lechuga mixta",
                "1 tomate",
                "1/2 pepino",
                "Aceite de oliva",
                "Limón y hierbas"
            ),
            instructions = listOf(
                "Sazonar pollo con hierbas",
                "Cocinar a la plancha por 6 minutos cada lado",
                "Preparar ensalada con vegetales",
                "Hacer aderezo con aceite y limón",
                "Servir pollo con ensalada"
            ),
            prepTime = 10,
            cookTime = 15,
            servings = 2,
            calories = 300,
            category = "Cena",
            difficulty = "Fácil",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        ),
        Recipe(
            id = "cena_5",
            name = "Vegetales Salteados con Tofu",
            description = "Vegetales frescos salteados con tofu y salsa de soja.",
            ingredients = listOf(
                "200g tofu firme",
                "1 brócoli",
                "1 pimiento rojo",
                "1 zanahoria",
                "2 cucharadas de salsa de soja",
                "1 cucharada de aceite de sésamo"
            ),
            instructions = listOf(
                "Cortar tofu en cubos",
                "Cortar vegetales en trozos",
                "Saltear tofu hasta dorar",
                "Agregar vegetales y saltear",
                "Condimentar con salsa de soja"
            ),
            prepTime = 15,
            cookTime = 15,
            servings = 2,
            calories = 220,
            category = "Cena",
            difficulty = "Fácil",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        )
    )
    
    val snacks = listOf(
        Recipe(
            id = "snack_1",
            name = "Manzana con Mantequilla de Almendras",
            description = "Manzana cortada en rodajas con mantequilla de almendras natural. Un snack saludable y energético.",
            ingredients = listOf(
                "1 manzana roja grande (Fuji o Gala)",
                "2 cucharadas de mantequilla de almendras natural (30g)",
                "1 cucharadita de canela en polvo (2g)",
                "1 cucharadita de miel natural (7g)",
                "1 cucharada de granola sin azúcar (15g)",
                "1 pizca de sal marina",
                "1 cucharadita de semillas de chía (5g)",
                "1/2 cucharadita de extracto de vainilla (2ml)"
            ),
            instructions = listOf(
                "Lavar bien la manzana bajo agua corriente",
                "Secar completamente con un paño limpio",
                "Cortar la manzana en rodajas de 1cm de grosor, evitando el centro",
                "Retirar las semillas y el corazón de cada rodaja",
                "En un bowl pequeño, mezclar la mantequilla de almendras con la miel",
                "Agregar el extracto de vainilla y una pizca de sal, mezclar hasta integrar",
                "Calentar ligeramente la mezcla en el microondas por 10-15 segundos",
                "Arreglar las rodajas de manzana en un plato de manera decorativa",
                "Untar cada rodaja con la mezcla de mantequilla de almendras",
                "Espolvorear canela en polvo sobre todas las rodajas",
                "Agregar granola y semillas de chía por encima",
                "Servir inmediatamente para evitar que la manzana se oxide",
                "Si se desea, rociar con un poco más de miel al momento de servir"
            ),
            prepTime = 8,
            cookTime = 0,
            servings = 1,
            calories = 180,
            category = "Snack",
            difficulty = "Fácil",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        ),
        Recipe(
            id = "snack_2",
            name = "Yogurt con Frutos Secos",
            description = "Yogurt griego con nueces, almendras y arándanos secos.",
            ingredients = listOf(
                "1 taza de yogurt griego",
                "1 cucharada de nueces",
                "1 cucharada de almendras",
                "1 cucharada de arándanos secos"
            ),
            instructions = listOf(
                "Servir yogurt en bowl",
                "Agregar frutos secos",
                "Mezclar suavemente"
            ),
            prepTime = 3,
            cookTime = 0,
            servings = 1,
            calories = 200,
            category = "Snack",
            difficulty = "Fácil",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        ),
        Recipe(
            id = "snack_3",
            name = "Hummus con Vegetales",
            description = "Hummus casero con zanahorias, pepino y apio para dipping.",
            ingredients = listOf(
                "1/2 taza de garbanzos cocidos",
                "2 cucharadas de tahini",
                "1 diente de ajo",
                "2 cucharadas de aceite de oliva",
                "1 zanahoria",
                "1/2 pepino"
            ),
            instructions = listOf(
                "Licuar garbanzos con tahini y ajo",
                "Agregar aceite de oliva",
                "Cortar vegetales en bastones",
                "Servir hummus con vegetales"
            ),
            prepTime = 10,
            cookTime = 0,
            servings = 2,
            calories = 150,
            category = "Snack",
            difficulty = "Fácil",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        ),
        Recipe(
            id = "snack_4",
            name = "Smoothie de Proteína",
            description = "Batido de proteína con plátano, leche y proteína en polvo.",
            ingredients = listOf(
                "1 plátano",
                "1 taza de leche",
                "1 cucharada de proteína en polvo",
                "1 cucharada de mantequilla de maní",
                "1 cucharadita de miel"
            ),
            instructions = listOf(
                "Pelar y cortar plátano",
                "Agregar todos los ingredientes a licuadora",
                "Licuar por 1 minuto",
                "Servir inmediatamente"
            ),
            prepTime = 5,
            cookTime = 0,
            servings = 1,
            calories = 320,
            category = "Snack",
            difficulty = "Fácil",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        ),
        Recipe(
            id = "snack_5",
            name = "Palomitas de Maíz Naturales",
            description = "Palomitas de maíz hechas en casa con aceite de coco y sal marina.",
            ingredients = listOf(
                "1/4 taza de granos de maíz",
                "1 cucharada de aceite de coco",
                "Sal marina al gusto"
            ),
            instructions = listOf(
                "Calentar aceite en olla grande",
                "Agregar granos de maíz",
                "Tapar y cocinar hasta que dejen de explotar",
                "Agregar sal al gusto"
            ),
            prepTime = 2,
            cookTime = 5,
            servings = 2,
            calories = 100,
            category = "Snack",
            difficulty = "Fácil",
            createdBy = "admin",
            createdAt = Date(),
            isPublic = true
        )
    )
    
    val todasLasRecetas = desayunos + almuerzos + cenas + snacks
}
