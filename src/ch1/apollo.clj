(ns ch1.apollo)

(def mission-defaults {:orbits 0, :evas 0})

(defn make-mission
  [name system launched manned? opts]
  (let [{:keys [cm-name
                lm-name
                orbits
                evas]} (merge mission-defaults opts)]
    ,,,))

(defn make-mission2
  [name system launched manned? & opts]
  (let [{:keys [cm-name
                lm-name
                orbits
                evas]
         :or {orbits 0, evas 0}} opts]
    ,,,))

(def apollo-4
  (make-mission "Apollo 4"
                "Saturn V"
                #inst "1967-11-09T12:00:01-00:00"
                false
                {:orbits 3}))

(defrecord Planet [namep
                   moons
                   volume
                   mass
                   aphelion
                   perihelion
                   orbital-eccentricity])

(defn euclidean-norm [ecc-vector] ,,,)

(defn make-planet
  "Make a planet from field values and an accentricity vector"
  [name moons volume mass aphelion perhelion ecc-vector]
  (->Planet
   name moons volume mass aphelion perhelion
   (euclidean-norm ecc-vector)))
