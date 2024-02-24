<template>
  <div id="home">
    <div class="" id="background-div">
      <!-- <img src="../assets/home.jpg" class="w-100 img-fluid" alt=""> -->
    </div>
     <div class="container p-5 text-center about-us col-sm-10">
        <div class="row">
          <h1 class="display-6">About Us</h1>
          <h4 class="mb-5">Royalty Car Rental</h4>
          <p class="text-start" style="font-size: large;">Our vision is to become the most customer centric company in car rental industry. We will be persistent in building strong relationships with our customers and business partners.<br><br>
              We will be constantly focusing on innovation and delivery of simple high-quality service to our customers. <br><br>
              We are convinced that we need to innovate and control the high technology behind our services, and to participate only in markets where we can make significant contribution. <br><br>
              We don’t settle for anything less than excellence in every branch office and group in the company. We have courage to admit when and if we are wrong and courage to change. <br><br>
              We strive to create local opportunity, competitive advantage growth, and impact in every branch office around the World. <br><br>
              Our strategy is to build best-in-class IT platforms which will enable us to be productive and to deliver carefully customized services.</p>
        </div>
     </div>
     
      <!-- sections -->
      <div class="nav navbar-expand-xxl nav-pills nav-fill mt-3" id="nav">
          <!-- our values dropdown -->
        <section class="nav-item text-start">
          <a class="nav-link page-sections active sticky-top" type="button"
              data-toggle="collapse" aria-label="Toggle navigation"
                 data-target="#ourValues" aria-expanded="true"
                  aria-controls="ourValues" id="ourValuesBtn">
                  01 Our Values
          </a>
          <div class="row g-0" id="ourValues" aria-labelledby="ourValuesBtn">
            <div class="col-md-6 text-white section-text">
              <div class="container-fluid pe-xl-0 h-100">
                <div class="d-flex flex-column justify-content-center align-items-start max-w-500 h-100 mx-auto ms-lg-0 me-lg-auto px-3 px-lg-3 py-5 py-xl-0">
                  <h2 class="">Our Values</h2>
                  <p>We always place the interests of our customers first. We always conduct business with implementation of high
                    standards, trust, honesty, professionalism and ethical behaviour.
                  </p>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <img src="../../src/assets/ceo1.jpg" class="img-fluid max-h-100-vh" alt="...">
            </div>
            <div class="row p-5 m-5 mx-0"></div>
            <div class="col-lg-6">
              <img src="../../src/assets/ceo2.jpg" class="img-fluid max-h-100-vh" alt="...">
            </div>
            <div class="col-lg-6 text-white section-text">
              <div class="container-fluid pe-xl-0 h-100">
                <div class="d-flex flex-column justify-content-center align-items-start max-w-500 h-100 mx-auto ms-lg-0 me-lg-auto px-3 px-lg-3 py-5 pt-1 py-xl-0">
                  <h1 class="p-0 m-0" style="font-size: 80px;">,,</h1>
                  <p>Talent is the No. 1 priority for a CEO. You think it's about vision and strategy, but you have to get the
                      right people first. Trustworthiness, honesty and reliability are the keystone values of Royalty Car Rental.
                      We are entirely committed to creating fully-cusomized service at the right price, whether it is for an
                      individual or a company's needs. It's as simple as that - we are the brand you can trust. <br><br>
                      <strong>Brian Langsoni</strong><br>CEO - Royalty Car Rental
                  </p>
                </div>
              </div>
            </div>
          </div>
        </section>

          <!-- our vision dropdown -->
        <div class="nav-item text-start">
          <a class="nav-link page-sections sticky-top active" type="button"
              data-toggle="collapse" aria-label="Toggle-navigation"
                aria-expanded="true" data-target="#ourVision"
                  aria-controls="ourVision">
                  02 Our Vision
          </a>
          <div class="row g-0" id="ourVision">
            <div class="col-md-6 text-white section-text">
              <div class="container-fluid pe-xl-0 h-100">
                <div class="d-flex flex-column justify-content-center align-items-start max-w-500 h-100 mx-auto ms-lg-0 me-lg-auto px-3 px-lg-3 py-5 py-xl-0">
                  <h2 class="">Our Vision</h2>
                  <p>Our Vision is to become one of the leading brands in the rental industry
                      of Africa and to build the wide network of branches in the World
                  </p>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <img src="../../src/assets/AppImages/benz.jpg" class="img-fluid max-h-100-vh" alt="...">
            </div>
          </div>
        </div>

        <!-- Our know-how dropdown -->
        <div class="nav-item text-start">
          <a class="nav-link page-sections sticky-top active" type="button"
              data-toggle="collapse" aria-label="Toggle-navigation"
                aria-expanded="true" data-target="#ourKnowHow"
                  aria-controls="ourKnowHow">
                  03 Our Know-How
          </a>
        </div>

        <!-- Our Locations dropdown -->
        <div class="nav-item text-start">
          <a class="nav-link page-sections sticky-top active" type="button"
              data-toggle="collapse" aria-label="Toggle-navigation"
                aria-expanded="true" data-target="#ourLocation"
                  aria-controls="ourLocation">
                  04 Our Locations
          </a>
        </div>
      </div>
     



    <!--    display categories-->
    <div class="container">
      <div class="row">
        <div class="col-12 text-center">
          <h2 class="pt-3 mt-4"> Top Categories</h2>
        </div>
      </div>
      <div class="row justify-content-evenly">
        <div v-for="index in this.categorySize" :key="index"
             class="col-md-6 col-xl-4 col-12 pt-3 my-2 justify-content-around">
          <CategoryBox :category="categories[index-1]" />
        </div>
      </div>
    </div>

    <!--    display Products-->
    <div class="container py-4">
      <div class="row">
        <div class="col-12 text-center">
          <h2 class="pt-3 pb-3">Top Vehicles</h2>
        </div>
      </div>
      <div class="row justify-content-evenly">
        <div v-for="index in this.productSize" :key="index"
          class="col-md-6 col-xl-4 col-12 pt-3 my-2 justify-content-around">
          <ProductBox :product="products[index-1]"/>
        </div>
      </div>
    </div>

  
  </div>
</template>

<script>
import CategoryBox from "../components/Category/CategoryBox.vue";
import ProductBox from "@/components/ProductBox.vue";





export default {
  name: "HomeView",
  components: {CategoryBox, ProductBox},
  props: ["categories", "products"],
  data() {
    return {
      categorySize: 0,
      productSize: 0
    }
  },
  methods:{
    scrollPositions(){
      // window.addEventListener('scroll', function() {
      //   var navbar = document.getElementById('nav');
      //   var toggleDiv = document.getElementById('ourValues');
      //   // Get the scroll position
      //   var scrollPosition = window.scrollY;

      //   // Get the position of the toggle div relative to the document
      //   var toggleDivPosition = toggleDiv.getBoundingClientRect().top + scrollPosition;

      //   // Define the scroll point where the sticky behavior should stop
      //   var scrollPoint = toggleDivPosition;

      //   // Check if the scroll position is beyond the scroll point
      //   if (scrollPosition >= scrollPoint) {
      //     navbar.classList.remove('sticky-top');
      //   } else {
      //     navbar.classList.add('sticky-top');
      //   }
      // });
    }
  },
  mounted() {
    this.categorySize = Math.min(6, this.categories.length );
    this.productSize = Math.min(8, this.products.length);
    // this.scrollPositions();
  }
};
</script>


<style scoped>

#background-div {
  margin-top: -15px;
  background: url("../../src/assets/home.jpg");
  background-size: cover !important;
  min-height: 90vh;
}
.section-text{
  background-color: #090051;
}
.section-text p{
  font-size: large;
}
  #home{
    background-color: rgb(241, 241, 241);
  }
  #heading {
    font-weight: 400;
  }
  .about-us{
    margin-top: -300px;
    margin-bottom: 2rem;
    background-color: rgba(255, 255, 255, 0.8);
    /* transition: all 1s ease-in-out 0s; */
  }
  div{
    transition: all 1s ease-in-out 0s;
  }
  .sticky-top{
    top: 120px;
  }
  .page-sections{
    border-radius: 0;
    display: flex;
    justify-content: center;
    padding: 16px;
  }
  @media (min-width: 0px) and (max-width: 992px) {
    div.about-us{
      margin-top: 2rem;
    }
  }
</style>