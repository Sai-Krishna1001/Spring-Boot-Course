
const FooterComponent = () => {
    const currrentYear = new Date().getFullYear();
    return (
        <div>
        <footer className="footer">
            <span>&copy; {currrentYear} All rights reserved  by Sai Krishna</span>
        </footer>
        </div>
    )
}

export default FooterComponent
