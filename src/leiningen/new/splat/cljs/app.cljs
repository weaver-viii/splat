(ns {{name}}.ui.app
  (:require [flow.core :as f :include-macros true]
            [clojure.string :as s]
            simple-brepl.client))

(enable-console-print!)

(defn code [s]
  (f/el
    [:strong {::f/style {:font-family "'Courier New', 'monospace'"}}
     s]))

(set! (.-onload js/window)
      (fn []
        (f/root js/document.body
          (f/el
            [:div.container
             [:h2 {::f/style {:margin-top "1em"}}
              "Hello from SPLAT!"]

             [:h3 "Things to try:"]
                  
             [:ul
              [:li [:p "In your Clojure REPL (in the 'user' ns), run " (code "(reload-frodo!)") " to completely reload the webapp without restarting the JVM."]]
              [:li [:p "Connect to a CLJS bREPL by running " (code "(simple-brepl)")]]
              [:li
               [:p "Once you've opened the bREPL, reload your browser to make the connection, then you can eval some CLJS."]
               [:p "I recommend:"]
                    
               [:ul
                [:li (code "(js/alert \"Hello world!\")")]
                [:li (code "(set! (.-backgroundColor js/document.body.style) \"green\")")]
                [:li (code (s/join "\n" ["(in-ns '{{name}}.ui.app)"
                                         "(d/replace-contents! (sel1 :#sample-div) (node [:strong \"Hi!\"]))"]))]]

               [:p "Run " (code ":cljs/quit") " to get back to a Clojure REPL."]]
              [:li [:p "Start making your webapp!"]
               [:ul
                [:li [:p "The CLJS entry point is in " (code "ui-src/{{sanitized}}/ui/app.cljs")]]
                [:li [:p "The Clojure Ring handler is in " (code "src/{{sanitized}}/service/handler.clj")]]]]

              [:li [:p "Any trouble, let me know - either through GitHub or on Twitter at " [:a {:href "https://twitter.com/jarohen"} "@jarohen"]]]

              [:li [:p "Good luck!"]]]

             [:div {::f/style {:text-align "right"
                               :font-weight "bold"}}
              [:p
               [:span {::f/style {:font-size "1.3em"}} "James Henderson"]
               [:br]
               "Twitter: " [:a {:href "https://twitter.com/jarohen"} "@jarohen"]
               [:br]
               "GitHub: " [:a {:href "https://github.com/james-henderson"} "james-henderson"]]]

                  
             [:div#sample-div]]))))


