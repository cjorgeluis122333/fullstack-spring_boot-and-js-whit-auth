const userName = document.getElementById("username")
const password = document.getElementById("pass")

const btnLogin = document.getElementById("login")

btnLogin.addEventListener("click", () => {
    if (userName.size <= 2 || password.size < 2) {
        //error
    } else {
    const result = sinIng()
    }


})

const sinIng = async () => {
    try {
//10.0.2.2:8090
        const response = await fetch("http://localhost:8090/login", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: {
                "username": "Jor",
                "password": "123"
            }
        })

        if (!response.ok) {
            throw new Error(`Error HTTP: ${response.status}`);
        }

        const getDate = await response.json();
        console.log(getDate)


    } catch (error) {
        console.error("Authentication error", error.message);

    }
}

