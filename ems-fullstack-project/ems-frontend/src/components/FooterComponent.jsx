const FooterComponent = () => {
  const currrentYear = new Date().getFullYear();
  return (
    <footer
      className=" mt-5 p-2 "
      style={{
        bottom: "0",
        width: "100%",
        backgroundColor: "black",
        textAlign: "center",
        color: "white",
        position:"absolute"
      }}
    >
      <span>&copy; {currrentYear} All rights reserved by Sai Krishna</span>
    </footer>
  );
};

export default FooterComponent;
