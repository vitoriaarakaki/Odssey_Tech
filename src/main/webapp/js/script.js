const filtrarMobile = document.querySelector('.menu-mobile');
const fecharMenu = document.querySelector('.fechar-menu');
const Abrirmenu = document.querySelector('.aside-menu')
Abrirmenu.addEventListener('click', function () {
  filtrarMobile.style.visibility = 'visible';
  filtrarMobile.style.width = '90%';
});
fecharMenu.addEventListener('click', function () {
  filtrarMobile.style.visibility = 'hidden';
  filtrarMobile.style.width = '0';
});


             // ANIMAÇÃO PASSAGENS 


var splide = new Splide( '.splide', {
  type    : 'loop',
  perPage : 3,
  autoplay: true,
   } );

  splide.mount();


           //ANIMAÇÃO BOTÃO UP 


  function scrolltop(){
  window.scrollTo({
  top:0,
  behavior: 'smooth'
  })
   }


   VanillaTilt.init(document.querySelectorAll(".cardi"), {
     max: 25,
     speed: 400,
     glare: true,
     "max-glare": 1,
   });

   