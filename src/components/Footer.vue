<template>
    <footer>
        <div class="container pt-5 px-3" style="font-family: Georgia, 'Times New Roman', Times, serif;">
            <div class="row justify-content-center">
                <div class="col-md-4 col-9">
                    <ul class="list-unstyled">
                    <li class="mb-2">
                        <a href="#" class="footer-link">
                            <router-link class="navbar-brand" :to="{ name: 'HomeView' }" >
                                <img id="logo" src="../../public/logo-dark.png"/>
                            </router-link>
                        </a>
                    </li>
                    <li class="text-light font-weight-bold pb-2">Follow us on our Social platforms</li>
                    <li class="row media-icons justify-content-start">
                        <div class="row">
                            <div class="footer-link col text-start"><a href="https://instagram.com/" class="footer-link bi bi-instagram"></a></div>
                            <div class="footer-link col text-start"><a href="https://linkedin.com/" class="footer-link bi bi-linkedin"></a></div>
                            <div class="footer-link col text-start"><a href="https://twitter.com/" class="footer-link bi bi-twitter"></a></div>
                            <div class="footer-link col text-start"><a href="https://facebook.com/" class="footer-link bi bi-facebook"></a></div>
                            <div class="footer-link col text-start"><a href="https://youtube.com/" class="footer-link bi bi-youtube"></a></div>
                        </div>
                    </li>
                    </ul>
                </div>
                <div class="col-md-2 col-9">
                    <ul  class="list-unstyled">
                    <li class="text-light font-weight-bold pb-2">Get to know us</li>
                    <li><router-link class="text-decoration-none footer-link" :to="{name: 'AboutUs'}">About</router-link></li>
                    <li><a href="#" class="footer-link">IOS App</a></li>
                    <li><a href="#" class="footer-link">Learn More</a></li>
                    </ul>
                </div>
                <div class="col-md-2 col-9">
                    <ul  class="list-unstyled">
                    <li class="text-light font-weight-bold pb-2">Quick Links</li>
                    <li><router-link class="text-decoration-none footer-link" :to="{name: 'HomeView'}">Home</router-link></li>
                    <li><router-link class="text-decoration-none footer-link" :to="{name: 'VehiclesView'}">Vehicles</router-link></li>
                    <li><a href="#" class="footer-link">FAQ</a></li>
                    <li><a href="#" class="footer-link">Service</a></li>
                    </ul>
                </div>
                <div class="col-md-2 col-9">
                    <ul  class="list-unstyled">
                    <li class="text-light font-weight-bold pb-2">Legal</li>
                    <li><a href="#" class="footer-link">Terms & Conditions</a></li>
                    <li><a href="#" class="footer-link">Privacy Policy</a></li>
                    <li><a href="#" class="footer-link">Feedback</a></li>
                    <li><a href="#" class="footer-link">Cookie Policy</a></li>
                    </ul>
                </div>
                <div class="col-md-2 col-9">
                    <ul  class="list-unstyled">
                        <li><router-link class="text-decoration-none footer-link" :to="{name: 'ContactUs'}">Contact Us</router-link></li>
                        <li><address class="text-light">2870 Mainway Meadows<br>
                                    Waterfalls, Harare<br>
                                    <a href="#" class="footer-link">0712768037</a>
                            </address>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
</template>

<script>
export default {
    name: "FooterView",
}
</script>

<style scoped>

footer{
    margin-top: 100px;
    background-color: #232f3e;
    font-size: 16px;
}
.footer-link{
    text-decoration: none;
    color: #ddd;
}
.footer-link:hover{
    color: darkgoldenrod;
}
li{
    padding-bottom: 10px;
}
ul{
    padding: 0px;
}
#logo {
  width: 150px;

}
@media screen {
    .container{
        padding: 48px 36px 0px
    }
}
</style>