import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import AddCategory from '../views/Category/AddCategory';
import AdminCategory from '../views/Category/AdminCategory';
import AdminProduct from '../views/Product/AdminProduct';
import Admin from "../views/Admin";
import AddProduct from "../views/Product/AddProduct";
import EditCategory from "../views/Category/EditCategory";
import EditProduct from "../views/Product/EditProduct"
import ShowDetails from "../views/Product/ShowDetails";
import ListProducts from "../views/Category/ListProducts";
import Signup from "../views/Signup";
import Signin from "../views/Signin";
import Wishlist from "../views/Product/Wishlist";
import Cart from "../views/Cart";
import Success from "../views/payment/Success";
import Failed from "../views/payment/Failed";
import Checkout from "../views/Checkout/Checkout";
import Users from "../views/Users";
import Vehicles from "../views/Vehicles";
import AboutUs from "../views/AboutUs";
import ContactUs from "../views/ContactUs";
import "../views/Admin.vue"
import NotFound from "../views/NotFound.vue"

const routes = [
  {
    path: '/home',
    name: 'HomeView',
    component: HomeView
  },
  {
    path: '/',
    redirect: '/home'
    },
  {
    path: '/admin/category/add',
    name: 'AddCategory',
    component: AddCategory
  },
  {
    path: '/admin/category',
    name: 'AdminCategory',
    component: AdminCategory
  },
    // category edit
  {
    path: '/admin/category/:id',
    name: 'EditCategory',
    component: EditCategory
  },
    // admin home page
  {
    path: '/admin',
    name: 'AdminView',
    component: Admin,
    // beforeEnter: (to, from, next) => {
    //   // Call your adminInfo method here
    //   adminInfo().then(() => {
    //     // Once the data is fetched, call next() to proceed with the navigation
    //     next();
    //   }).catch((error) => {
    //     // Handle errors, for example by redirecting to an error page
    //     console.error(error);
    //     next(false);
    //   });
    // }
  },
  {
    path: '/admin/vehicles',
    name: 'AdminProduct',
    component: AdminProduct
  },
    // add product
  {
    path: '/admin/vehicle/new',
    name: 'AddProduct',
    component: AddProduct
  },
  // edit product
  {
    path: '/admin/vehicle/:id',
    name: 'EditProduct',
    component: EditProduct
  },
  //show product details
  {
    path: '/vehicle/show/:id/:name',
    name: 'ProductDetails',
    component: ShowDetails
  },
  //show category products
  {
    path: '/category/show/:id',
    name: 'ListProducts',
    component: ListProducts
  },
  //SignUp page
  {
    path:'/user/signup',
    name: 'SignupView',
    component: Signup
  },
  //SignIn page
  {
    path:'/user/signin',
    name: 'SigninView',
    component: Signin
  },
  //wishlist page
  {
    path: '/wishlist',
    name: 'WishList',
    component: Wishlist
  },
  //Cart page
  {
    path: '/cart',
    name: 'CartView',
    component: Cart
  },
  //stripe payment success page
  {
    path: '/payment/success',
    name: 'StripeSuccess',
    component: Success
  },
  //stripe payment failed page
  {
    path: '/payment/failed',
    name: 'StripeFailed',
    component: Failed
  },
  //checkout page
  {
    path: '/checkout',
    name: 'CheckoutPage',
    component: Checkout
  },
  //users page
  {
    path: '/admin/users',
    name: 'UsersView',
    component: Users
  },
  //show all vehicles
  {
    path: '/vehicles/',
    name: 'VehiclesView',
    component: Vehicles
  },
  //Contact us page
  {
    path: '/contact',
    name: 'ContactUs',
    component: ContactUs
  },
  //show all vehicles
  {
    path: '/about',
    name: 'AboutUs',
    component: AboutUs
  },
  //the not found path
  { path: '/:pathMatch(.*)*',
    name: 'NotFound',
    component: NotFound
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,

  scrollBehavior(to, from, savedPosition) {
    if (savedPosition) {
      // If a saved position is available, return to that position
      return savedPosition;
    } else {
      // Scroll to the top of the page
      return { top: 0 };
    }
  },
});



export default router