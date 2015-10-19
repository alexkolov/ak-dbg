(ns dbg.core
  (:require
   [puget.printer :as puget]))

(defn pprint-str [x]
  (with-out-str
    (puget/cprint x)))

(defmacro dbg [x]
  `(let [x# ~x]
     (printf "--------------\ndbg %s:%s> %s is:\n%s"
             ~*ns*
             ~(:line (meta &form))
             ~(pr-str x)
             (pprint-str x#))
     (flush)
     x#))
